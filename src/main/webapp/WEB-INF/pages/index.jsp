<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

<%-- 	<sec:authorize access="hasRole('ROLE_USER')"> --%>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
		<!-- For login user -->
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>

		<nav>
			<ul>
				<li><a href="<%=request.getContextPath()%>/films">films</a></li>
				<li><a href="<%=request.getContextPath()%>/actuurs">Acteurs</a></li>
				<li><a href="<%=request.getContextPath()%>/realisateurs">Realisateur</a></li>
			</ul>
		</nav>
	</sec:authorize>
</body>
</html>