package com.andersen.shop;

import com.andersen.shop.config.ApplicationConfig;
import com.andersen.shop.config.DispatcherConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


public class AppLauncher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class, DispatcherConfig.class);
        context.refresh();
    }
}
