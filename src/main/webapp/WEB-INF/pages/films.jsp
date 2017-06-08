<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 	<sec:authorize access="hasRole('ROLE_ADMIN')"> --%>
		<h1>Title : ${title}</h1>
		<ul>
			<c:forEach var="film" items="${filmList}">
				<li>${film.titre}
					<c:forEach var="acteur" items="${film.listActeurs}">
				${acteur.nom}
				
			</c:forEach>
			</li>
			</c:forEach>
		</ul>
<%-- 	</sec:authorize> --%>
</body>
</html>