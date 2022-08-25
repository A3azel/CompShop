<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 24.04.2022
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ua">
<head>
    <title>Shop</title>
    <link href="CSS/catalogfile.css" rel="stylesheet" type="text/css">
    <link href="CSS/SameCSS.css" rel="stylesheet" type="text/css">
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>a
<div class="wrapper">
    <div id="leftsidebar">
        <form action="shop" method="get">

            <p><input type="checkbox" name="v1" value="processors">Процессори</p>
            <p><input type="checkbox" name="v1" value="motherboards">Плати</p>
            <p><input type="checkbox" name="v1" value="RAM">RAM</p>
            <p><input type="checkbox" name="v1" value="videoCards">Відео карти</p>
            <p><input type="submit" value="Знайти"></p>

        </form>
    </div>
    <div id="main">

        <c:forEach var="compComponent" items="${requestScope.ComponentsList}">
            <div id="product-item">
                <img src="${compComponent.componentPhotoURL}" alt="${compComponent.componentName}" />

                <p><a href="product?productID=${compComponent.componentID}">${compComponent.componentName}</a></p>

                <p>${compComponent.componentPrise} ₴ </p>

                <form action="product" method="get" >
                    <button name="productID" value="${compComponent.componentID}">Купити</button>
                </form>
            </div>
        </c:forEach>
    </div>
</div>
<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>
