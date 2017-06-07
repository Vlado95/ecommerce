<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>page acteurs</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Ajouter un acteur
</h1>

<c:url var="addAction" value="/acteurs/add" ></c:url>

<form:form action="${addAction}" commandName="acteur">
<table>
	<c:if test="${!empty acteur.nom}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="nom">
				<spring:message text="Nom"/>
			</form:label>
		</td>
		<td>
			<form:input path="nom" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="prenom">
				<spring:message text="Prenom"/>
			</form:label>
		</td>
		<td>
			<form:input path="prenom" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty acteur.nom}">
				<input type="submit"
					value="<spring:message text="Edit Acteur"/>" />
			</c:if>
			<c:if test="${empty acteur.nom}">
				<input type="submit"
					value="<spring:message text="Add Acteur"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>


<h3>Liste des acteurs: </h3>
<c:if test="${!empty acteurList}">
	<table class="tg">
	<tr>
		<th width="80">Acteur ID</th>
		<th width="120">Acteur Nom</th>
		<th width="120">Acteur Prénom</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
        
	<c:forEach var="acteur" items="${acteurList}">
		<tr>
			<td>${acteur.id}</td>
			<td>${acteur.nom}</td>
			<td>${acteur.prenom}</td>
			<td><a href="<c:url value='/edit/${acteur.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${acteur.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>