<%--
  Created by IntelliJ IDEA.
  User: Phan Minh Huy
  Date: 4/8/2020
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<form action="/displayDiscount" method="post">
    <p>Product Description:</p>
    <input type="text" name="productDescription"/>
    <p>List Price:</p>
    <input type="text" name="listPrice"/>
    <p>Discount Percent:</p>
    <input type="text" name="discountPercent"/>(%) </br>
    <input type="submit" id="submit" value="Calculate Discount"/>
</form>
</body>
</html>
