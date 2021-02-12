package com.andersen.shop.dao;

import com.andersen.shop.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
    private final SessionFactory sessionFactory;
    private final CountryDao countryDao;

    public ProductDaoImpl(SessionFactory sessionFactory, CountryDao countryDao) {
        this.sessionFactory = sessionFactory;
        this.countryDao = countryDao;
    }

    @Override
    public void add(Product product) {
        product.setCountry(countryDao.findByName(product.getCountry().getName()));
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }

    @Override
    public Product getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product where id =: id");
        query.setParameter("id", id);
        return (Product) query.uniqueResult();
    }

    @Override
    public List<Product> getAll() {
        return sessionFactory.getCurrentSession().createQuery("Select p from Product p", Product.class).getResultList();
    }

    @Override
    public void deleteById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Product where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
