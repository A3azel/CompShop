<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 01.05.2022
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ua">
<head>
    <meta charset="utf-8">
    <title>${requestScope.toOrder.componentName}</title>

    <link href="CSS/instant_buy.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>
<div class="container">
    <p>${requestScope.toOrder.componentName}</p>
    <div id="image">
        <img src="${requestScope.toOrder.componentPhotoURL}" alt="alt="${requestScope.toOrder.componentName}" />
    </div>
    <p>${requestScope.toOrder.componentCategory}</p>
    <p>${requestScope.toOrder.componentDescription}</p>
    <p>${requestScope.toOrder.componentPrise}</p>
    <form action="toOrder" method="post">
        <button type="submit" name="action" value="by">Підтвердити замовлення</button>
    </form>
</div>

<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>