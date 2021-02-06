package com.andersen.shop.service;

import com.andersen.shop.Product;
import com.andersen.shop.dao.ProductDao;
import com.andersen.shop.dao.ProductDaoImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public int add(Product product) {
        return productDao.add(product);
    }

    @Override
    public Product getById(int id) {
        return getById(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void deleteById(int id) {
        productDao.deleteById(id);
    }
}
