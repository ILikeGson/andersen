package com.andersen.shop.dao;

import com.andersen.shop.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/shop?user=root&password=password";
    private JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Product product) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update("INSERT INTO products(price, product_name, product_description, creating_date, expiring_date, is_expired) VALUES (?, ?, ?, ?, ?, ?)",
                product.getPrice(), product.getName(), product.getDescription(),
                Date.valueOf(product.getCreatedDate()), Date.valueOf(product.getExpiredDate()), product.isExpired());
    }

    @Override
    public Product getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE product_id = ?", new ProductRowMapper(), id);
    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query("SELECT * FROM products", new ProductRowMapper());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM products WHERE product_id = ?", id);
    }

    private class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt(1);
                int price = resultSet.getInt(2);
                String name = resultSet.getString(3);
                String description = resultSet.getString(4);
                LocalDate createdDate = resultSet.getDate(5).toLocalDate();
                LocalDate expiredDate = resultSet.getDate(6).toLocalDate();
                boolean isExpired = resultSet.getBoolean(7);
                return new Product(id, price, name, description, createdDate, expiredDate, isExpired);
        }
    }
}
