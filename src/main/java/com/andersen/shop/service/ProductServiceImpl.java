package com.andersen.shop.service;

import com.andersen.shop.model.Product;
import com.andersen.shop.dao.ProductDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getById(int id) {
        return getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        productDao.deleteById(id);
    }
}
