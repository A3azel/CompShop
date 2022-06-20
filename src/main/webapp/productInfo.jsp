<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 14.06.2022
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ua">
<head>
    <title>Управління товаром</title>
    <link href="CSS/productInfo.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>
<div class="wrapper">
    <div class="container">
        <c:forEach var="product" items="${requestScope.allCompComponents}">
            <p>ID: ${product.componentID}</p>
            <p>Category: ${product.componentCategory}</p>
            <p>Name: ${product.componentName}</p>

            <form action="adminPanelProductInfo" method="get" style=" float: left;">
                <button name="Update product" value="${product.componentID}">Редагувати</button>
            </form>

            <form action="adminPanelProductInfo" method="post">
                <button name="Delete product" value="${product.componentID}">Видалити</button>
            </form>
            <hr>
        </c:forEach>
    </div>
</div>
<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>
