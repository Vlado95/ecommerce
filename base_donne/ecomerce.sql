-- Change le délimiteur pour pouvoir écrire des ; dans la
-- procédure stockée

DELIMITER §

DROP SCHEMA IF EXISTS eboutique §
CREATE SCHEMA IF NOT EXISTS eboutique DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci §
USE eboutique §

-- users
CREATE TABLE IF NOT EXISTS users (
  id_user INT(20) NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  pwd  VARCHAR(45) NOT NULL,
  enabled TINYINT(1) NOT NULL,
  PRIMARY KEY (id_user),
  UNIQUE INDEX email_UNIQUE (email ASC))
ENGINE = InnoDB DEFAULT CHARSET=latin1 §



CREATE TABLE IF NOT EXISTS roles (
  id_role INT(11) NOT NULL AUTO_INCREMENT,
  id_user INT(11) NOT NULL,
  role_name VARCHAR(20) NOT NULL,
  PRIMARY KEY (id_role),
  CONSTRAINT fk_role_user
    FOREIGN KEY (id_user) REFERENCES users (id_user))
ENGINE = InnoDB DEFAULT CHARSET=latin1 §



	--- procedure pour initialise la base de donnee 
	
DROP PROCEDURE IF EXISTS eboutique_refresh §
CREATE DEFINER=root@localhost PROCEDURE eboutique_refresh()
BEGIN
	-- Lever temporairement les contraintes d'intégrité
	SET FOREIGN_KEY_CHECKS=0;
	TRUNCATE users;
	TRUNCATE roles;
	-- Remettre les contraintes d'integrite
	SET FOREIGN_KEY_CHECKS=1;

	BEGIN
	  DECLARE EXIT HANDLER FOR SQLSTATE '23000'
	  BEGIN
		SHOW ERRORS;
        ROLLBACK;
	  END;
		START TRANSACTION;
        
		-- contenu de base
	INSERT INTO users(id_user,nom, prenom, email,pwd,enabled) VALUES
		(1, 'Haddock', 'Archibald', 'haddock@moulinsart.be','karara',1),
		(2,'Castafiore', 'Bianca', 'bianca.castafiore@scala.it','kamiri',1),
		(3, 'Tournesol', 'Tryphon', 'tournesol@moulinsart.be','milou',1);

	INSERT INTO roles (id_role, id_user, role_name) VALUES
		(1, 1,'ROLE_SUPER_ADMIN' ),
		(2, 1,'ROLE_ADMIN'),
		(3, 2,'ROLE_ADMIN'),
		(4, 3,'ROLE_USER');

	  COMMIT;
	END;
END§

-- fin contenu simulé

DROP FUNCTION IF EXISTS initcap§
CREATE FUNCTION initcap(chaine text) RETURNS text CHARSET utf8
deterministic
BEGIN
 DECLARE gauche, droite text;
 SET gauche='';
 SET droite ='';
 WHILE chaine LIKE '% %' DO -- si elle contient un espace
 SELECT SUBSTRING_INDEX(chaine, ' ', 1) INTO gauche;
 SELECT SUBSTRING(chaine, LOCATE(' ', chaine) + 1) INTO chaine;
 SELECT CONCAT(droite, ' ',
 CONCAT(UPPER(SUBSTRING(gauche, 1, 1)),
 LOWER(SUBSTRING(gauche, 2)))) INTO droite;
 END WHILE;
 RETURN LTRIM(CONCAT(droite, ' ',
CONCAT(UPPER(SUBSTRING(chaine,1,1)), LOWER(SUBSTRING(chaine, 2)))));
END§

DROP TRIGGER IF EXISTS trigger_insert_users§
CREATE TRIGGER trigger_insert_users
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
-- prénom capitalisé en INSERT
	SET NEW.prenom = upper(trim(NEW.prenom));

-- nom en majuscule en INSERT
  SET NEW.nom = trim(upper(NEW.nom));
  
  -- adresse email sans espace en INSERT
   SET NEW.email = trim(NEW.email);
END§

DROP TRIGGER IF EXISTS users_before_update_trigger§
CREATE TRIGGER users_before_update_trigger
BEFORE UPDATE ON users
FOR EACH ROW
BEGIN
 SET NEW.prenom = trim(initcap(NEW.prenom));
 SET NEW.nom = trim(upper(NEW.nom));
 SET NEW.email = trim(NEW.email);
END§



-- DELIMITER §
call eboutique_refresh()§