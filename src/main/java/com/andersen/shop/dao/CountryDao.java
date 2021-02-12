package com.andersen.shop.dao;

import com.andersen.shop.model.Country;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao {
    private final SessionFactory sessionFactory;

    public CountryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Country findByName(String name) {
        Query query= sessionFactory.getCurrentSession().
                createQuery("from Country where name=:name");
        query.setParameter("name", name);
        return (Country) query.uniqueResult();
    }

    public Country findById(int id) {
        Query query= sessionFactory.getCurrentSession().
                createQuery("from Country where id=:id");
        query.setParameter("id", id);
        return (Country) query.uniqueResult();
    }
}
