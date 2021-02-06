package com.andersen.shop.controller;

import com.andersen.shop.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new ProductServiceImpl().deleteById(Integer.parseInt(req.getRequestURL().toString().split("=")[1]));
        resp.sendRedirect("/products");
    }
}
