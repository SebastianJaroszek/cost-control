<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cost Control App</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"></head>
<body>
    <jsp:include page="menu.jsp" />
    Dodaj/edytuj wydatek:
    <form:form action="${action}" modelAttribute="newCost" method="post">
        <form:input type="hidden" path="id"/><br>
        <form:label path="name">Nazwa wydatku:</form:label>
        <form:input path="name"/><br>
        <form:label path="type">Typ wydatku:</form:label>
        <form:input path="type"/><br>
        <form:label path="date">Data wydatku:</form:label>
        <form:input path="date"/><br>
        <form:label path="amount">Kwota wydatku:</form:label>
        <form:input path="amount"/><br>

        <input type="submit" name="apply" value="Zatwierdz"/>
    </form:form>
</body>
</html>
