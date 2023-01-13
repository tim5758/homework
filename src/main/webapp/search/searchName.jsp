<%--
  Created by IntelliJ IDEA.
  User: tim09
  Date: 2023/1/13
  Time: 下午 07:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/getProductByName" method="get">
  <label>商品名稱: </label>
  <input type="text" name="productName">
  <input type="submit" value="搜尋">


</form>

</body>
</html>
