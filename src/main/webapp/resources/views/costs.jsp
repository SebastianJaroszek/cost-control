<%--
  Created by IntelliJ IDEA.
  User: trutyna
  Date: 2018-02-25
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cost Control App</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet"></head>
</head>
<body>
    <jsp:include page="menu.jsp" />
    Moje koszty:<br>

    <table>
        <thead>
            <tr>
                <td>Nazwa</td>
                <td>Ile</td>
                <td>Kiedy</td>
                <td>Czym placone</td>
                <td>Szczegoly</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${costs}" var="cost">
                <tr>
                    <td>${cost.name}</td>
                    <td>${cost.amount}</td>
                    <td>${cost.costDate}</td>
                    <td>${cost.type}</td>
                    <td><a href="${pageContext.servletContext.contextPath}/cost/${cost.id}">Przejdz</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
