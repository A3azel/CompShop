<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 16.06.2022
  Time: 01:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ua">
<head>
    <title>Product info for admin</title>
    <link href="CSS/productInfoForAdmin.css" rel="stylesheet" type="text/css">
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>
<div class="wrapper">
    <div id="container">
        <p>
            <label>Виберіть категорію: </label>
            <select name="category"  >
                <option value="Motherboards"<c:choose><c:when test="${requestScope.productInfo.componentCategory.equals('Motherboards')}">selected="selected"</c:when></c:choose>>Материнська плата</option>
                <option value="Processors" <c:choose><c:when test="${requestScope.productInfo.componentCategory.equals('Processors')}">selected="selected"</c:when></c:choose>>Процессор</option>
                <option value="RAM"<c:choose><c:when test="${requestScope.productInfo.componentCategory.equals('RAM')}">selected="selected"</c:when></c:choose>>PAM</option>
                <option value="VideoCards"<c:choose><c:when test="${requestScope.productInfo.componentCategory.equals('VideoCards')}">selected="selected"</c:when></c:choose>>Відео-карта</option>
            </select>
        </p>
        <p>
            <label>Введіть модель: </label>
            <input name="compModel" type="text" value="${requestScope.productInfo.componentName}">
        </p>
        <p>
            <label>Введіть опис: </label>
            <input name="compDescription" type="text" value="${requestScope.productInfo.componentDescription}">
        </p>
        <p>
            <label>Введіть ціну: </label>
            <input name="compDescription" type="text" value="${requestScope.productInfo.componentPrise}">
        </p>
        <p>
            <label>Введіть кількість: </label>
            <input name="compCount" type="text" value="${requestScope.productInfo.componentCount}">
        </p>
        <p>
            <label>Введіть назву фото: </label>
            <input name="compPhoto" type="text" value="${requestScope.productInfo.componentPhotoURL}">
        </p>
        <form action="adminPanelProductInfo" method="post" >
            <button name="Update product" value="${requestScope.productInfo.componentID}">Редагувати</button>
            <button name="Delete product" value="${requestScope.productInfo.componentID}">Видалити</button>
        </form>
    </div>
</div>
<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>