<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23.04.2022
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

    <title>Registration</title>
    <link href="CSS/registrationFile.css" rel="stylesheet" type="text/css">
    <link href="CSS/headerStyle.css" rel="stylesheet" type="text/css">
    <link href="CSS/footerStile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="wrapper">
    <form name="ac" action="registration" method="post">
        <h1>Реєстрація</h1>
        <div>
            <p>
                <label accesskey="l">Логин: </label>
                <input name="username" type="text" size="30" placeholder="Введіть логин">
            </p>

            <c:choose>
                <c:when test="${requestScope.LoginErrors != null}">
                    <p style="color: red">${requestScope.LoginErrors}</p>
                </c:when>
            </c:choose>
        </div>
        <div>
            <p>
                <label accesskey="p">Пароль: </label>
                <input name="userPassword" type="password" size="30" placeholder="Введіть пароль">
            </p>
            <c:choose>
                <c:when test="${requestScope.PasswordErrors != null}">
                    <p style="color: red">${requestScope.PasswordErrors}</p>
                </c:when>
            </c:choose>
        </div>
        <div>
            <p>
                <label>Підтвердіть пароль: </label>
                <input name="userPasswordSubmit" type="password" size="30" placeholder="Введіть пароль">
            </p>
            <c:choose>
                <c:when test="${requestScope.DifferentPasswords != null}">
                    <p style="color: red">${requestScope.DifferentPasswords}</p>
                </c:when>
            </c:choose>

            <p>
        </div>
        <div>
            <p>
                <label accesskey="e">Введіть e-mail: </label>
                <input name="userEmail" type="email" size="30" placeholder="Введіть адрес електронной пошти">
            </p>
            <c:choose>
                <c:when test="${requestScope.EmailErrors != null}">
                    <p style="color: red">${requestScope.EmailErrors}</p>
                </c:when>
            </c:choose>

        </div>
        <div>
            <p>
                <label accesskey="f">Телефон: </label>
                <input name="userPhone" type="text" size="30" placeholder="Телефон">
            </p>
            <c:choose>
                <c:when test="${requestScope.PhoneErrors != null}">
                    <p style="color: red">${requestScope.PhoneErrors}</p>
                </c:when>
            </c:choose>
        </div>
        <div>
            <p>
                <label accesskey="s">Виберіть стать: </label>
                <select name="sex" >
                    <option value="not specified">not specified</option>
                    <option value="man">man</option>
                    <option value="woman">woman</option>
                </select>
            </p>
        </div>
        <p text-align: center><input style="text-align: center; display: block;
    margin: auto;  padding: 4px 8px;  background: #3A0A50; border: 6px solid #3A0A50; color: whitesmoke" type="submit" value="Зареєструватися"/></p>
    </form>

</div>

<div id="footer">
    <jsp:include page="footerFile.HTML" />
</div>

</body>
</html>
