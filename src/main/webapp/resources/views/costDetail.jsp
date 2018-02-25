<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cost Control App</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"></head>
<body>
<jsp:include page="menu.jsp" />
Wydatek : ${cost.name} <br>
Suma : ${cost.amount} <br>
Data : ${cost.costDate} <br>
Typ : ${cost.type} <br>
</body>
</html>
