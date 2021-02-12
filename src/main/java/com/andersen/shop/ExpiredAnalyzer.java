package com.andersen.shop;

import com.andersen.shop.model.Product;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class ExpiredAnalyzer {
    public void analyze(Product product) {
        try {
            Class<?> theClass = product.getClass();
            Field expiredDate = theClass.getDeclaredField("expiredDate");
            Field isExpired = theClass.getDeclaredField("isExpired");
            expiredDate.setAccessible(true);
            isExpired.setAccessible(true);
            Object localDate = expiredDate.get(product);
            if (LocalDate.now().isAfter((LocalDate)localDate)) {
                isExpired.setBoolean(product, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
