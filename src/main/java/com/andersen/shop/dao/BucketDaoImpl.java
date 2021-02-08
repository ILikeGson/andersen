package com.andersen.shop.dao;

import com.andersen.shop.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class BucketDaoImpl implements BucketDao {
    private final JdbcTemplate jdbcTemplate;

    public BucketDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addProductToUserBucketById(int userId, int id) {
        jdbcTemplate.update("INSERT INTO bucket VALUES(?, ?)", userId, id);
    }

    @Override
    public List<Product> getAll(int userId) {
        return jdbcTemplate.query("SELECT * FROM bucket where bucket_id = ?", new BucketRowMapper(), userId);
    }

    @Override
    public void removeProductById(int userId, int id) {
        jdbcTemplate.update("DELETE FROM bucket WHERE bucket_id = ? AND product_id = ?", userId, id);
    }

    private class BucketRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            int productId = resultSet.getInt(2);
            return jdbcTemplate.queryForObject("SELECT * FROM products WHERE product_id = ?", new ProductRowMapper(), productId);
        }
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
