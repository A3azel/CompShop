<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 26.04.2022
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ua">
<head>
    <meta charset="utf-8">
    <title>${requestScope.findProduct.componentName}</title>
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/product.css" rel="stylesheet" type="text/css">
    <link href="CSS/SameCSS.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>
<div class="wrapper">
    <div id="mainProduct">
        <h1>${requestScope.findProduct.componentName}</h1>
        <div id="box">
            <div id="image">
                <img src="${requestScope.findProduct.componentPhotoURL}" alt="${requestScope.findProduct.componentName}" />
            </div>
            <div id="parametrs">
                <p>Ціна: ${requestScope.findProduct.componentPrise} ₴</p>
                <p>Опис: ${requestScope.findProduct.componentDescription}</p>
                <form action = "product" method = "get">
                    <button type="submit" name="action" value="by">Купити</button>
                    <button type="submit" name="action" value="addToBasket">Додати до кошика</button>
                </form>
            </div>

        </div>

    </div>
</div>
<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>
