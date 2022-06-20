<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 26.04.2022
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--<html>
<head>
    <title>Корзина</title>
</head>
<body>
${sessionScope.basketProduct.componentName}
</body>
</html>--%>

<%--<!DOCTYPE html>
<html lang="ua">
<head>
    <meta charset="utf-8">
    <title>Корзина</title>
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/basketFile.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <jsp:include page="headerFile.HTML" />
</div>
<div class="wrapper">
    <div class="container">
        <form action="toOrder" method="post">
            <p>Кошик</p>
            <div class="cart_items">
                <div class="image-box">
                    <img src="${sessionScope.basketProduct.componentPhotoURL}" alt="${sessionScope.basketProduct.componentName}" />
                    <div class="about">
                        <p class="title">${sessionScope.basketProduct.componentName}</p>
                        <p class="price">${sessionScope.basketProduct.componentPrise}</p>
                    </div>
                </div>
            </div>
            <input type="submit" text-align: center value = "Підтвердити замовлення">
        </form>
        <form>
            <input type="submit" text-align: center value="Видалити">
        </form>
    </div>
</div>
<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>--%>


<!DOCTYPE html>
<html lang="ua">
<head>
        <meta charset="utf-8">
        <title>Корзина</title>
        <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
        <link href="CSS/basketFile.css" rel="stylesheet" type="text/css">
        <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>
<div class="wrapper">
    <div id="container">
        <h1>Кошик</h1>

            <c:forEach var="productOnTheBasket" items="${sessionScope.basketCompList}">
                <div id="basket-item">
                <p>
                    <img src="${productOnTheBasket.componentPhotoURL}" alt="${productOnTheBasket.componentName}" />
                </p>
                <div class="about">
                    <p>
                        Назва: ${productOnTheBasket.componentName}
                    </p>
                    <p>
                        Ціна: ${productOnTheBasket.componentPrise} ₴
                    </p>
                </div>
                <div id="buttons">
                    <%--<form action="basket" method="get">
                        <button type="submit" name="seeAllInfo" value="${productOnTheBasket.componentID}">Переглянути</button>
                    </form>--%>
                    <form action="basket" method="post">
                        <button type="submit" name="byThisComp" value="${productOnTheBasket.componentID}">Купити</button>
                        <button type="submit" name="removeFromBasket" value="${productOnTheBasket.componentID}">Видалити</button>
                    </form>
                </div>
        </div>
            </c:forEach>

    </div>
</div>
<div id="footer" style=" text-align: center;">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>
