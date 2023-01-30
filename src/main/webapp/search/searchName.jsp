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
<form action="/myWeb/searchByName" method="get">
  <label>商品名稱: </label>
  <input type="text" name="productName">
  <input type="submit" value="搜尋">
</form>
<br/>
<%
    if(request.getAttribute("productList") != null){
        productList = (ArrayList<Product>) request.getAttribute("productList");
        for(Product product: productList){
%>
商品ID：<%=product.getProductId()%> 商品名稱：<%=product.getProductName()%> 商品分類：<%=product.getCategory()%>
商品價格：<%=product.getPrice()%> 商品庫存：<%=product.getStock()%> 上架日期：<%=product.getCreatedDate()%><br/>
<%
        }
    }
%>




<%--<%--%>
<%--    if(request.getAttribute("productList") != null){--%>
<%--        productList = (ArrayList<Product>) request.getAttribute("productList");--%>
<%--        for(int i=0; i<productList.size(); i++){--%>
<%--            printWriter.println(productList.get(i));--%>
<%--            printWriter.println("<br/>");--%>
<%--        }--%>
<%--    }--%>
<%--%>--%>
</body>
</html>
