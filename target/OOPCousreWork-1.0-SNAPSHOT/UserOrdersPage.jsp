<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 01.05.2022
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Історія замовлень</title>
    <link href="CSS/SameCSS.css" rel="stylesheet" type="text/css">
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>
<div id="container">
    <h1>Історія замовлень</h1>
    <c:forEach var="userOrders" items="${requestScope.userOrders}">
        <p>
            <a href="selectedOrder?action=${userOrders.ID}">${userOrders.orderComp}</a>
        </p>
        <p>
           Дата замовлення: ${userOrders.orderCreateTime}
        </p>
        <p>
            Статус: ${userOrders.orderStatus}
        </p>
        <hr/>
    </c:forEach>
</div>
<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>