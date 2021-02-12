package com.andersen.shop.dao;

import com.andersen.shop.model.InternetShop;
import com.andersen.shop.model.InternetShopBucket;
import com.andersen.shop.model.Product;
import com.andersen.shop.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BucketDaoImpl implements BucketDao {
    private final SessionFactory sessionFactory;
    private final CountryDao countryDao;

    public BucketDaoImpl(SessionFactory sessionFactory, CountryDao countryDao) {
        this.sessionFactory = sessionFactory;
        this.countryDao = countryDao;
    }

    @Override
    public void addProductToUserBucketById(int userId, int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product p where p.id = :id");
        query.setParameter("id", id);
        Product product = (Product) query.getSingleResult();

        Query anotherQuery = session.createQuery("from User u where u.id = :userId");
        anotherQuery.setParameter("userId", id);
        User user = (User)anotherQuery.getSingleResult();
        user.getBucket().addProduct(product);
        session.flush();
    }

    @Override
    public List<Product> getAll(int userId) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, userId);
        return user.getBucket().getProductBucket();
    }

    @Override
    public void removeProductById(int userId, int id) {
        Session session = sessionFactory.getCurrentSession();
        Query anotherQuery = session.createQuery("from InternetShopBucket u where u.id = :userId");
        anotherQuery.setParameter("userId", userId);
        InternetShopBucket bucket = (InternetShopBucket) anotherQuery.getSingleResult();
        bucket.removeById(id);
    }
}
