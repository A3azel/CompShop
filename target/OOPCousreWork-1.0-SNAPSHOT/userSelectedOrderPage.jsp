<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 07.05.2022
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>${requestScope.selectedOrders.orderComp}</title>
    <link href="CSS/userOrdersSelect.css" rel="stylesheet" type="text/css">
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>
<div class="wrapper">
    <div id="container">
    ID замовлення: <p>${requestScope.selectedOrders.ID}</p>
    Назва товару: <p>${requestScope.selectedOrders.orderComp}</p>
    Ціна покупки: <p>${requestScope.selectedOrders.orderPrise} ₴</p>
    Дата замовлення: <p>${requestScope.selectedOrders.orderCreateTime}</p>
    Статус замовлення: <p>${requestScope.selectedOrders.orderStatus}</p>
        </div>
</div>
<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>
