package com.andersen.shop.controller;

import com.andersen.shop.Product;
import com.andersen.shop.service.ProductService;
import com.andersen.shop.service.ProductServiceImpl;
import org.apache.tomcat.jni.Local;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class MainServlet extends HttpServlet {
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService = new ProductServiceImpl();
        resp.setContentType("text/html");
        req.setAttribute("products", productService.getAll());
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService = new ProductServiceImpl();
        int price = Integer.parseInt(req.getParameter("price"));
        String name = req.getParameter("name");
        String description  = req.getParameter("description");
        LocalDate createdDate = LocalDate.parse(req.getParameter("created"));
        LocalDate expiredDate = LocalDate.parse(req.getParameter("expired"));
        productService.add(new Product(price, name, description, createdDate, expiredDate));
        resp.sendRedirect("/products");
    }
}
