<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<title>page films</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h1>Ajouter un film</h1>

	<form:form method="post" commandName="film">
		<table>
			<c:if test="${!empty film.titre}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="titre">
						<spring:message text="Title" />
					</form:label></td>
				<td><form:input path="titre" /></td>
			</tr>
			<tr>
				<td><form:label path="duree">
						<spring:message text="Duree" />
					</form:label></td>
				<td><form:input path="duree" /></td>
			</tr>
			<tr>
				<td><form:label path="langue">
						<spring:message text="Langue" />
					</form:label></td>
				<td><form:input path="langue" /></td>
			</tr>
			<tr>
				<td><form:label path="publics">
						<spring:message text="Public" />
					</form:label></td>
				<td><form:input path="publics" /></td>
			</tr>
			<tr>
				<td><form:label path="origine">
						<spring:message text="Origine" />
					</form:label></td>
				<td><form:input path="origine" /></td>
			</tr>
			<tr>
				<td><form:label path="format">
						<spring:message text="Format" />
					</form:label></td>
				<td><form:input path="format" /></td>
			</tr>
			<tr>
				<td><form:label path="quantite">
						<spring:message text="Qauntité" />
					</form:label></td>
				<td><form:input path="quantite" /></td>
			</tr>
			<tr>
				<td><form:label path="prix">
						<spring:message text="Prix" />
					</form:label></td>
				<td><form:input path="prix" /></td>
			</tr>
			<tr>
				<td><form:label path="resume">
						<spring:message text="Resumé" />
					</form:label></td>
				<td><form:input path="resume" /></td>
			</tr>
			<tr>

				<td colspan="2">


					<button type="submit">${action}</button>
					<label>Genre :</label> 
					<form:select path="genre.id">
							<c:forEach items="${genres}" var="genre">
									<form:option value="${genre.id}">${genre.nom}</form:option>
							</c:forEach>
					</form:select> 
							<label>Acteurs :</label> 
									<select path="acteur.id" multiple size="2">
										<c:forEach items="${acteurs}" var="acteur">
											<option value="${acteur.id}">${acteur.nom}</option>
										</c:forEach>
									</select> 
	<!--                     <select name="toto" id="toto" type="select" multiple size="2"> -->

					<!-- <option value="">Tous</option><option value="2016">2016</option><option value="2015">2015</option><option value="2014">2014</option><option value="2013">2013</option><option value="2012">2012</option><option value="2011">2011</option> -->




				</td>
			</tr>

		</table>
	</form:form>
	<br>


	<h3>Liste des films:</h3>
	<c:if test="${!empty filmList}">
		<table class="tg">
			<tr>
				<th width="40">Film ID</th>
				<th width="120">Film Titre</th>
				<th width="80">Film Quantité</th>
				<th width="100">Film Prix</th>
				<th width="80">Film Format</th>
				<th width="100">Film Origine</th>
				<th width="80">Film Langue</th>
				<th width="200">Film Resume</th>

				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>

			<c:forEach var="film" items="${filmList}">
				<tr>
					<td>${film.id}</td>
					<td>${film.titre}</td>
					<td>${film.quantite}</td>
					<td>${film.prix}</td>
					<td>${film.format}</td>
					<td>${film.origine}</td>
					<td>${film.langue}</td>
					<td>${film.resume}</td>
					<td>
						<c:forEach var="acteur" items="${film.listActeurs}">
							<ul>
								<li>${acteur.nom}</li>
							</ul>
						</c:forEach>
					</td>
					<td><a href="<c:url value='/edit/${film.id}' />">Edit</a></td>
					<td><a href="<c:url value='/remove/${film.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
