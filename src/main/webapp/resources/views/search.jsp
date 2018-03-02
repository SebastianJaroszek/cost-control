<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cost Control App</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"></head>
<body>
<jsp:include page="menu.jsp" />
Wyszukaj transakcje po kwotach:
<form:form action="search" modelAttribute="newSearch" method="POST">
    <form:label path="from">stawka od:</form:label>
    <form:input type="number" path="from"/><br>

    <form:label path="from">stawka do:</form:label>
    <form:input type="number" path="to"/><br>

    <form:label path="name">nazwa:</form:label>
    <form:input type="text" path="name"/><br>

    <input type="submit" name="apply" value="wyszukaj"/>
</form:form>
</body>
</html>
