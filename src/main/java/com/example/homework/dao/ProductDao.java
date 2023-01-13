package com.example.homework.dao;

import com.example.homework.model.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDao {

    Connection connection;
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

    public void getProductByName(String productName){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded...");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load Driver");
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework", "root", "Password123");
            System.out.println("database connected...");
        } catch (SQLException e) {
            System.out.println("Failed to connect MySQL database");
            throw new RuntimeException(e);
        }

        String sql = "SELECT * FROM product WHERE product_name LIKE ? ;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + productName + "%");
        } catch (SQLException e) {
            System.out.println("Failed to setting sql parameter");
            throw new RuntimeException(e);
        }
        ArrayList<Product> productList = new ArrayList<>();
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
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
        } catch (SQLException e) {
            System.out.println("Failed to search product name");
            throw new RuntimeException(e);
        }

        for(Product product : productList){
            System.out.println(product);
        }
    }
}
