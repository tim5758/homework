package com.example.homework.servlet;

import com.example.homework.dao.ProductDao;
import com.example.homework.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetProductByNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");

        ProductDao productDao = new ProductDao();
        ArrayList<Product> productList = null;
        try {
            productList = productDao.getProductByName(productName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/search/searchName.jsp").forward(req, resp);

    }
}
