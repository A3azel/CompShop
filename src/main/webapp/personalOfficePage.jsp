<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23.04.2022
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Personal office</title>
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <%--<link href="CSS/cabinetStyle.css" rel="stylesheet" type="text/css">--%>
    <link href="CSS/SameCSS.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
        <%--<jsp:include page="headerFile.jsp"/>--%>
</div>
<div class="wrapper">
<div class="qqq">
dfghjkjhgf
</div>

    <form id = "officeForm">
        <h1>Особистий кабінет</h1>
        <p>Ім'я: ${sessionScope.user.userName}</p>
        <p>Адрес електронної пошти: ${sessionScope.user.userEmail}</p>
        <p>Номер телефону: ${sessionScope.user.userPhone}</p>
        <p>Стать: ${sessionScope.user.userSex}</p>
        <p>Статус: ${sessionScope.user.userStatus}</p>
        <form  action="office" method="get">
            <button class="officeButtons" name="action" value="changPassword" >Змінити пароль</button>
            <button class="officeButtons" name="action" value="exit" >Вийти з облікового запису</button>
            <button class="officeButtons" name="action" value="myOrders" <%--text-align: center--%>>Мої замовлення</button>
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
<script>
/*    let qqq= document.querySelector(".qqq");
    qqq.innerHTML = '${sessionScope.user.userName}';
    qqq.style.color = "red";*/
</script>
</body>
</html>
