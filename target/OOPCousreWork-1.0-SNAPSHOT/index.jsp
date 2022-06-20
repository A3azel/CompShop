<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form name="ac" action="login" method="post">


    <p>
        <label accesskey="l">Логин: </label>
        <input name="username" type="text" size="30" placeholder="Уведить логин"> </p>


    <p>
        <label accesskey="p">Пароль: </label>
        <input name="userPassword" type="password" size="30" placeholder="Уведить пароль"></p>
    <p><input type="submit" value="Войти"/></p>
    <p><input type="submit" value="Очистити"/></p>
    <a href="RegistrationPage.jsp">Реєстрація</a>

</form>
<c:choose>
    <c:when test="${requestScope.userErrors != null}">
       <p style="color: red">${requestScope.userErrors}</p>
    </c:when>
</c:choose>
&lt;%&ndash;${requestScope.qqq}&ndash;%&gt;
</body>
</html>--%>



<!DOCTYPE html>
<html lang="ua">
<head>
    <meta charset="utf-8">
    <title>Авторизація</title>
    <link href="CSS/authorization.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="wrapper" style="min-height: 100%;">
    <form name="ac" action="login" method="post">
        <div class="container">
            <h1>Вхід на сайт</h1>
            <div>
                <label  accesskey="l">Логін:</label>
                <p><input style="color: black" name="username" type="text" size="30" placeholder="Введіть логин" required /></p>
            </div>
            <div>
                <label accesskey="p">Пароль:</label>
                <p><input style="color: black" name="userPassword" type="password" size="30" placeholder="Введіть пароль" required /></p>
            </div>
            <div>
                <input style="text-align: center; display: block;
    margin: auto;  padding: 4px 8px;  background: #3A0A50; border: 6px solid #3A0A50;" type="submit" value="Вхід"/>
            </div>
            <div id="center">
                <a href="RegistrationPage.jsp">Реєстрація</a>
            </div>
            <c:choose>
            <c:when test="${requestScope.userErrors != null}">
            <p style="color: red">${requestScope.userErrors}</p>
            </c:when>
            </c:choose>
    </form>
</div>
<%--<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>--%>

</body>
</html>