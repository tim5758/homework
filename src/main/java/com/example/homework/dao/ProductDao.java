package com.example.homework.dao;

import com.example.homework.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductDao {

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
}
