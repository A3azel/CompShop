<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 15.06.2022
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ua">
<head>
    <title>User info for admin</title>
    <link href="CSS/userInfoForAdmin.css" rel="stylesheet" type="text/css">
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>
<div class="wrapper">
<div id="container">
    <p>ID: ${requestScope.userInfo.userID}</p>
    <p>Ім'я: ${requestScope.userInfo.userName}</p>
    <p>Адрес електронної пошти: ${requestScope.userInfo.userEmail}</p>
    <p>Номер телефону: ${requestScope.userInfo.userPhone}</p>
    <p>Вік: ${requestScope.userInfo.userAge}</p>
    <p>Стать: ${requestScope.userInfo.userSex}</p>
    <p>Статус: ${requestScope.userInfo.userStatus}</p>
    <c:choose>
        <c:when test="${!requestScope.userInfo.userStatus.equals('admin')}">
            <form action="adminPanelUsersInfo" method="post">
                <button name="userIDPost" value="${requestScope.userInfo.userID}">Видалити</button>
                <button name="upgradeUser" value="${requestScope.userInfo.userID}">Зробити адміністратором</button>
            </form>
        </c:when>
    </c:choose>
</div>
    </div>
<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>
