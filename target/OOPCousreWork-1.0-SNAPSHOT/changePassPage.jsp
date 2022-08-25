<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 26.04.2022
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ua">
<head>
    <meta charset="utf-8">
    <title>Зміна паролю</title>
    <%--<link href="CSS/change_password.css" rel="stylesheet" type="text/css">--%>
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/SameCSS.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <nav><a href="office">Особистий кабінет</a> | <a href="basket.jsp">Кошик</a>  | <a href="shop">Магазин</a></nav>
</div>
<div class="wrapper">
    <div class="container">
        <form action="changePass" method="post">
            <h1>Зміна паролю</h1>
            <div>
                <input class="registrationInput" name="oldPassword" <%--style="margin-bottom: 20px;"--%> type="text" size="30" placeholder="Введіть старий пароль">
            </div>
            <div>
                <input class="registrationInput" name="newPassword" <%--style="margin-bottom: 20px;"--%> type="text" size="30" placeholder="Введіть новий пароль">
            </div>
            <input id="regBut" type="submit" value="Підтвердити" <%--style="text-align: center; display: block;
  margin: auto; background: #3A0A50;"--%>>
        </form>
    </div>
</div>
<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>
</body>
</html>