<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23.04.2022
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html>
<head>
    <title>Personal office</title>
</head>
<body>

<h3>Особистий кабінет</h3>

<h4>Ім'я: ${sessionScope.user.userName}</h4>
<h4>Пароль: ${sessionScope.user.userPassword}</h4>
<h4>Адрес електронної пошти: ${sessionScope.user.userEmail}</h4>
<h4>Номер телефону: ${sessionScope.user.userPhone}</h4>
<h4>Вік: ${sessionScope.user.userAge}</h4>
<h4>Стать: ${sessionScope.user.userSex}</h4>
<h4>Статус: ${sessionScope.user.userStatus}</h4>



<form action="office">
    <button name="action" value="changPassword">Змінити пароль</button>
    <button name="action" value="exit">Вийти з облікового запису</button>
    <button name="action" value="myOrders">Мої замовлення</button>
    <p><a href="shop">Магазин</a></p>
    <p><a href="basket.jsp">Корзина</a></p>
    <c:choose>
        <c:when test="${sessionScope.user.userStatus.equals('admin')}">
            <p ><a href="admin/usersPanel">Список користувачів</a></p>
            <a href="admin/productPanel">Список товарів</a>
        </c:when>
    </c:choose>

</form>
&lt;%&ndash;<c:forEach var="user" items="${requestScope.user}">
    ${user.userName}

</c:forEach>&ndash;%&gt;


</body>
</html>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Personal office</title>
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/cabinetStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>
<div class="wrapper">

    <form>
        <h1>Особистий кабінет</h1>
        <p>Ім'я: ${sessionScope.user.userName}</p>
        <p>Адрес електронної пошти: ${sessionScope.user.userEmail}</p>
        <p>Номер телефону: ${sessionScope.user.userPhone}</p>
        <%--<p>Вік: ${sessionScope.user.userAge}</p>--%>
        <p>Стать: ${sessionScope.user.userSex}</p>
        <p>Статус: ${sessionScope.user.userStatus}</p>
        <form action="office" method="get">
            <button name="action" value="changPassword" text-align: center>Змінити пароль</button>
            <button name="action" value="exit" text-align: center>Вийти з облікового запису</button>
            <button name="action" value="myOrders" text-align: center>Мої замовлення</button>
            <p><a href="shop">Магазин</a></p>
            <p><a href="basket.jsp">Корзина</a></p>
            <c:choose>
                <c:when test="${sessionScope.user.userStatus.equals('admin')}">
                    <p ><a href="adminPanelUsersInfo">Список користувачів</a></p>
                    <a href="adminPanelProductInfo">Список товарів</a>
                </c:when>
            </c:choose>
        </form>
    </form>
</div>
<div id="footer">
        <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>
