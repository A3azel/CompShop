<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 14.06.2022
  Time: 03:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ua">
<head>
    <title>Управління користувачами</title>
    <link href="CSS/SameCSS.css" rel="stylesheet" type="text/css">
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>
<div id="container">
    <c:forEach var="registeredUsers" items="${requestScope.allUsers}">
        ID: ${registeredUsers.userID} <br />
        Ім'я: ${registeredUsers.userName} <br />
        E-mail: ${registeredUsers.userEmail} <br />
        Статус: ${registeredUsers.userStatus} <br />
        <form action="adminPanelUsersInfo" method="get" >
            <button name="userByName" value="${registeredUsers.userName}" style="float: left;">Інформація</button>
        </form>
        <c:choose>
            <c:when test="${!registeredUsers.userStatus.equals('admin')}">
                <form action="adminPanelUsersInfo" method="post">
                    <button name="userIDPost" value="${registeredUsers.userID}">Видалити</button>
                    <button name="upgradeUser" value="${registeredUsers.userID}">Зробити адміністратором</button>
                </form>
            </c:when>
        </c:choose>
        <hr>
    </c:forEach>
</div>
<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>




