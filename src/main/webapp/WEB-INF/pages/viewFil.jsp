<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="panier" >
		<c:if test="${panier.size!=0}">
			<table>
				<tr>
					<th>ID</th>
					<th>Titre</th>
					<th>Prix</
					<th>Quantité</th>
					<th>Montant</th>
				</tr>
				<c:forEach items="${panier.items}" var="art">
					<tr>
						<td>${art.film.id}</td>
						<td>${art.film.titre}</td>
						<td>${art.film.prix}</td>
						<td>${art.quantite}</td>
						<td>${art.quantite*art.film.prix}</td>
						<td colspan="2">
							<form action="supprimerAuPanier">
								<input type="hidden" value="${art.film.id}" name="idFilm"> 
								<input type="submit" value="Supprimer">
							</form>
						<td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4">Total</td>
					<td>${panier.total}</td>
				</tr>
			</table>

		</c:if>
	</div>
	<div id="catalogueProduits">
		<c:forEach items="${films}" var="f">
			<div class="fichefilm">
				<table>
					<!-- 					<tr> -->
					<!-- 						<td colspan="2"><img alt="" -->
					<%-- 							src="photoProduit?idP=${f.id }"></td> --%>
					<!-- 					</tr> -->
					<tr>
						<td>Titre :</td>
						<td>${f.titre }</td>
					</tr>
					<tr>
						<td>Prix :</td>
						<td>${f.prix}</td>
					</tr>
					<tr>
						<td>Stock:</td>
						<td>${f.quantite}</td>
					</tr>
					<tr>
						<td>${f.resume }</td>
					</tr>
					<tr>
						<td colspan="2">
							<form action="ajouterAuPanier">
								<input type="hidden" value="${f.id}" name="idFilm"> <input
									type="text" value="1" name="quantite"> <input
									type="submit" value="Ajouter au panier">
							</form>
						<td>
					</tr>
				</table>
			</div>
		</c:forEach>
	</div>
</body>
</html>