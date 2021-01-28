package com.andersen.shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class ApplicationTest {
    private RequestHandler requestHandler;
    private InternetShop internetShop;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream stdout = System.out;
    private final InputStream stdin = System.in;
    private static final String PRODUCT_LIST = "product id: 0\nproduct price: 11\nproduct description: cucumber-new";



    @BeforeEach public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(stdin);
        System.setOut(stdout);
    }

    @Test
    public void testShowAllProductsAndExit() {
        ByteArrayInputStream in1 = new ByteArrayInputStream(("showProducts\r\n" + "exit\r\n").getBytes());
        System.setIn(in1);
        requestHandler = new RequestHandler(new InternetShop(), new ConsoleIOService());
        requestHandler.handleRequest();
        String out = output.toString();
        assertEquals(PRODUCT_LIST, out.trim());
    }

    @Test
    public void testAddProductToTheBucketAndExit() {
        ByteArrayInputStream in1 = new ByteArrayInputStream(("addProductToTheBucket, 0\r\n" + "exit\r\n").getBytes());
        System.setIn(in1);
        internetShop = new InternetShop();
        requestHandler = new RequestHandler(internetShop, new ConsoleIOService());
        requestHandler.handleRequest();
        assertEquals(internetShop.getBucket().getProductBucket().size(), 1);
    }

    @Test
    public void testShowAllProductsInTheBucket() {
        ByteArrayInputStream in1 = new ByteArrayInputStream(("addProductToTheBucket, 0\r\n" + "showProductsInTheBucket\r\n" + "exit\r\n").getBytes());
        System.setIn(in1);
        internetShop = new InternetShop();
        requestHandler = new RequestHandler(internetShop, new ConsoleIOService());
        requestHandler.handleRequest();
        String out = output.toString();
        assertEquals(PRODUCT_LIST, out.trim());
    }

    @Test
    public void testRemoveProductFromTheBucket() {
        ByteArrayInputStream in1 = new ByteArrayInputStream(("addProductToTheBucket, 0\r\n" + "deleteProductFromTheBucket\r\n" + "exit\r\n").getBytes());
        System.setIn(in1);
        internetShop = new InternetShop();
        requestHandler = new RequestHandler(internetShop, new ConsoleIOService());
        requestHandler.handleRequest();
        assertEquals(internetShop.getBucket().getProductBucket().size(), 0);
    }
}
