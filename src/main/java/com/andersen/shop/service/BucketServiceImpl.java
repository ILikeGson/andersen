package com.andersen.shop.service;

import com.andersen.shop.Product;
import com.andersen.shop.dao.BucketDao;
import com.andersen.shop.dao.BucketDaoImpl;

import java.util.List;

public class BucketServiceImpl implements BucketService {
    private final BucketDao bucketDao = new BucketDaoImpl();


    @Override
    public void addProductToUserBucketById(int userId, int id) {
        bucketDao.addProductToUserBucketById(userId, id);
    }

    @Override
    public List<Product> getAll(int userId) {
        return bucketDao.getAll(userId);
    }

    @Override
    public void removeProductById(int userId, int id) {
        bucketDao.removeProductById(userId, id);
    }
}
