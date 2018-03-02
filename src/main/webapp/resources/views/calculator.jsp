<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cost Control App</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">
</head>
<body>
<jsp:include page="menu.jsp"/>
Kalkulator:
<form:form action="calculate" modelAttribute="newCalculator" method="POST">
    <form:input type="number" path="parametr1"/>

    <form:input type="text" path="operator"/>

    <form:input type="number" path="parametr2"/>
    = ${result}
    <br>
    <input type="submit" name="apply" value="oblicz"/>
</form:form>
</body>
</html>