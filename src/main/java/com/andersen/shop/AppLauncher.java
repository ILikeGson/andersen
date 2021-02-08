package com.andersen.shop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppLauncher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/view/applicationContext.xml");
    }
}
