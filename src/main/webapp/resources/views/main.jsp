<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cost Control App</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"></head>
<body>
<jsp:include page="menu.jsp" />
Aplikacja do kontrolowania wydatków
<br>
Imię: ${firstname}<br>
Nazwisko: ${lastname}<br>
Stan konta: ${balance}PLN<br>
</body>
</html>
