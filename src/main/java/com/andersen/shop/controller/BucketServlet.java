package com.andersen.shop.controller;

import com.andersen.shop.service.BucketService;
import com.andersen.shop.service.BucketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BucketServlet extends HttpServlet {
    private BucketService bucketService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String URL = req.getRequestURL().toString();
        resp.setContentType("text/html");
        bucketService = new BucketServiceImpl();
        if (URL.contains("add")) {
            int [] array = parseUrl(URL);
            int userId = array[1], productId = array[2];
            bucketService.addProductToUserBucketById(userId, productId);
            req.setAttribute("bucketProducts" ,bucketService.getAll(userId));
            //URL = URL.replaceAll(".add.*", "");
        } else if (URL.contains("delete")) {
            int [] array = parseUrl(URL);
            int userId = array[1], productId = array[2];
            bucketService.removeProductById(userId, productId);
            req.setAttribute("bucketProducts" ,bucketService.getAll(userId));
            //URL = URL.replaceAll(".delete.*", "");
        } else {
            int id = Integer.parseInt(URL.replaceAll(".*/", "").trim());
            req.setAttribute("bucketProducts" ,bucketService.getAll(id));
        }
        req.getRequestDispatcher("/bucket.jsp").forward(req, resp);
    }

    private int[] parseUrl(String url) {
        int[] ints = new int[3];
        String[] arr = url.split("\\D+");
        for (int i = 0; i < 3; i++) {
            ints[i] = Integer.parseInt(arr[i+1].trim());
        }
        return ints;
    }
}
