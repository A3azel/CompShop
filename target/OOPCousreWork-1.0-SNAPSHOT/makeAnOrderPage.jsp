<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 02.05.2022
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.toOrder.componentName}</title>
</head>
<body>
<p>${requestScope.toOrder.componentName}</p>
<img src="${requestScope.toOrder.componentPhotoURL} " alt="${requestScope.toOrder.componentName}" width="200px" height="200px" >
<p>${requestScope.toOrder.componentCategory}</p>
<p>${requestScope.toOrder.componentDescription}</p>
<p>${requestScope.toOrder.componentPrise}</p>

<form method="post">
    <button type="submit" name="action" value="by">Підтвердити замовлення</button>
</form>

</body>
</html>
