package com.example.homework.dao;

import com.example.homework.model.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDao {
    PreparedStatement preparedStatement;

    // 試做未完成
    public void getProducts() throws SQLException {
        String sql = "SELECT * FROM product";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework", "root", "Password123");
        if(connection != null){
            System.out.println("success!");
        }else{
            System.out.println("fail");
        }

    }

    public ArrayList<Product> getProductByName(String productName) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded...");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework", "root", "Password123");
        System.out.println("database connected...");

        String sql = "SELECT * FROM product WHERE product_name LIKE ? ;";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + productName + "%");

        ArrayList<Product> productList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Integer productId = resultSet.getInt("product_id");
            String name = resultSet.getString("product_name");
            String category = resultSet.getString("category");
            Integer price = resultSet.getInt("price");
            Integer stock = resultSet.getInt("stock");
            Timestamp createdDate = resultSet.getTimestamp("created_date");
            Timestamp lastModifiedDate = resultSet.getTimestamp("last_modified_date");
            Product product = new Product(productId, name, category, price, stock, createdDate, lastModifiedDate);
            productList.add(product);
        }

        System.out.println("ProductDao裡的productList有" + productList.size());
        return productList;
    }
}
