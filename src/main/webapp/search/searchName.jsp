<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.homework.model.Product" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Product> productList = new ArrayList<>();
    PrintWriter printWriter = response.getWriter();%>
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
<br/>
<%
    if(request.getAttribute("productList") != null){
        productList = (ArrayList<Product>) request.getAttribute("productList");
        for(int i=0; i<productList.size(); i++){
            printWriter.println(productList.get(i));

            printWriter.println("<br/>");
        }
    }
%>


</body>
</html>
