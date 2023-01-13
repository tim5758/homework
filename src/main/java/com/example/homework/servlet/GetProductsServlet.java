package com.example.homework.servlet;

import com.example.homework.dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "GetProductsServlet", value = "/GetProductsServlet")
public class GetProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDao productDao = new ProductDao();
        try {
            productDao.getProducts();
        } catch (SQLException e) {
            System.out.println("there's a problem");
            throw new RuntimeException(e);
        }
    }
}
