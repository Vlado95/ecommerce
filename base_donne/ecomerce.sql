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
  role VARCHAR(20) NOT NULL,
  enabled TINYINT(1) NOT NULL,
  PRIMARY KEY (id_user),
  UNIQUE INDEX email_UNIQUE (email ASC))
ENGINE = InnoDB DEFAULT CHARSET=latin1 §


-- film
CREATE TABLE IF NOT EXISTS films (
  id_film INT(20) NOT NULL AUTO_INCREMENT,
  titre VARCHAR(255) NOT NULL,
  resume VARCHAR(4000) NOT NULL,
  langue VARCHAR(20) NOT NULL,
  duree  VARCHAR(20) NOT NULL,
  id_genre VARCHAR(11) NOT NULL,
  id_acteur VARCHAR(11) NOT NULL,
  publics VARCHAR(20) NOT NULL,
  origine VARCHAR(20) NOT NULL,
  format VARCHAR(20) NOT NULL,
  quantite INT(20) NOT NULL,
  prix DOUBLE  NOT NULL,
  enabled TINYINT(1) NOT NULL,
  PRIMARY KEY (id_film),
  CONSTRAINT fk_film_genre
    FOREIGN KEY (id_genre)
    REFERENCES genre (id_genre)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_film_acteur
    FOREIGN KEY (id_acteur)
    REFERENCES acteur (id_acteur)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=latin1 §


-- genre
CREATE TABLE IF NOT EXISTS genre (
  id_genre INT(20) NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_genre))
ENGINE = InnoDB DEFAULT CHARSET=latin1 §


-- realisateur
CREATE TABLE IF NOT EXISTS realisateur (
  id_realisateur INT(20) NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_realisateur))
ENGINE = InnoDB DEFAULT CHARSET=latin1 §


-- acteur
CREATE TABLE IF NOT EXISTS acteur (
  id_acteur INT(20) NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_acteur))
ENGINE = InnoDB DEFAULT CHARSET=latin1 §

-- film_acteur
CREATE TABLE IF NOT EXISTS film_acteur (
  id_film INT(20) NOT NULL ,
  id_acteur INT(20) NOT NULL,
  PRIMARY KEY (id_film, id_film),
  CONSTRAINT fk_film_acteur
    FOREIGN KEY (id_film)
    REFERENCES films (id_film)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_acteur_film
    FOREIGN KEY (id_acteur)
    REFERENCES acteur (id_acteur)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=latin1 §

-- commande
CREATE TABLE IF NOT EXISTS commande (
  id_commande INT(20) NOT NULL AUTO_INCREMENT,
  ref_cmd VARCHAR(255) NOT NULL,
  id_lcmd INT(20) NOT NULL,
  id_client INT(20) NOT NULL,
  date_cmd DATE NOT NULL,
  status VARCHAR(45) NOT NULL,
  adresse_liv  VARCHAR(255) NOT NULL,
  delai_jr INT(20) NOT NULL,
  frais_port DOUBLE NOT NULL,
  montant_total DOUBLE NOT NULL,
  PRIMARY KEY (id_commande),
  UNIQUE INDEX ref_UNIQUE (ref_cmd),
   CONSTRAINT fk_id_lcmd_cmd
    FOREIGN KEY (id_lcmd)
    REFERENCES ligne_commande (id_lcmd)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_client_cmd
    FOREIGN KEY (id_client)
    REFERENCES clients(id_client)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=latin1 §


-- ligne_commande
CREATE TABLE IF NOT EXISTS ligne_commande (
  id_lcmd INT(20) NOT NULL AUTO_INCREMENT,
  id_film INT(20) NOT NULL,
  id_lcmd INT(20) NOT NULL,
  quantite INT(20) NOT NULL,
  prix DOUBLE NOT NULL,
  PRIMARY KEY (id_lcmd),  
  CONSTRAINT fk_film_cmd
    FOREIGN KEY (id_film )
    REFERENCES film (id_film)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=latin1 §



-- client
CREATE TABLE IF NOT EXISTS clients (
  id_client INT(20) NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  pwd  VARCHAR(45) NOT NULL,
  adresse VARCHAR(255) NOT NULL,
  telephone VARCHAR(20) NOT NULL,
  PRIMARY KEY (id_user),
  UNIQUE INDEX email_UNIQUE (email ASC))
ENGINE = InnoDB DEFAULT CHARSET=latin1 §


	--- procedure pour initialise la base de donnee 
	
DROP PROCEDURE IF EXISTS eboutique_refresh §
CREATE DEFINER=root@localhost PROCEDURE eboutique_refresh()
BEGIN
	-- Lever temporairement les contraintes d'intégrité
	SET FOREIGN_KEY_CHECKS=0;
	TRUNCATE users;
    TRUNCATE films;
    TRUNCATE clients;
    TRUNCATE acteur;
    TRUNCATE genre;
    TRUNCATE realisateur;
    TRUNCATE ligne_commande;
    TRUNCATE commande;
    TRUNCATE film_acteur;
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
	INSERT INTO users(id_user,nom, prenom, email,pwd,role,enabled) VALUES
		(1, 'Haddock', 'Archibald', 'haddock@moulinsart.be','karara','ROLE_ADMIN',1),
		(2,'Castafiore', 'Bianca', 'bianca.castafiore@scala.it','kamiri','ROLE_USER',1),
		(3, 'Tournesol', 'Tryphon', 'tournesol@moulinsart.be','milou','ROLE_USER',1);

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