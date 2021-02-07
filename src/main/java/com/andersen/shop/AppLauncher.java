package com.andersen.shop;

import com.andersen.shop.dao.ProductDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppLauncher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/view/applicationContext.xml");
        System.out.println(context.getBean(ProductDaoImpl.class).getAll());
    }
}
