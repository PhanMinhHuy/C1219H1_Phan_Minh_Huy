<%--
  Created by IntelliJ IDEA.
  User: Phan Minh Huy
  Date: 4/8/2020
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="models.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIST CUSTOMER</title>
    <link rel="stylesheet" type="text/CSS" href="CSS/Style.css">
</head>
<body>


<form action="/ListCustomer" method="get">
<h2 id="Title">LIST CUSTOMER</h2>
<table border="1" width="1280">
    <tr>
        <th>Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach var="i" items="${customer}" >
        <tr>
            <td><c:out value="${i.getNameCustomer()}" /></td>
            <td><c:out value="${i.getBirthday()}" /></td>
            <td><c:out value="${i.getAddress()}" /></td>
            <td><img src="https://scontent.fdad4-1.fna.fbcdn.net/v/t1.0-9/92367877_648170872415415_6111644337999708160_o.jpg?_nc_cat=109&_nc_sid=ca434c&_nc_oc=AQn28Eb8KW4FJwmAjwExE92Qt6xYcuqoia8g1hAgWrHMj6xD_mVW-e2N1Yj6P1-MlpE&_nc_ht=scontent.fdad4-1.fna&oh=6158a74931b9630b9ae683de5facd97c&oe=5EB607E4" width="100" height="70"></td>
        </tr>
    </c:forEach>


</table>
</form>
</body>
</html>
