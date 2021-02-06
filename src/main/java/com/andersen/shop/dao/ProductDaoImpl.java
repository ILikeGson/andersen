package com.andersen.shop.dao;

import com.andersen.shop.Product;
import com.andersen.shop.dao.jdbc.JdbcUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/shop?user=root&password=password";
    private static Connection connection;

    static {
        try {
            Class.forName(DRIVER);
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    @Override
    public int add(Product product) {
        connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO products(price, product_name, product_description, creating_date, expiring_date, is_expired) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, product.getPrice());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setDate(4, Date.valueOf(product.getCreatedDate()));
            preparedStatement.setDate(5, Date.valueOf(product.getExpiredDate()));
            preparedStatement.setBoolean(6, product.isExpired());

            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        //throw new RuntimeException("Product wasn't added");
        return 1;
    }

    @Override
    public Product getById(int id) {
        Product product = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM products where product_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int price = resultSet.getInt(2);
                String name = resultSet.getString(3);
                String description = resultSet.getString(4);
                LocalDate createdDate = resultSet.getDate(5).toLocalDate();
                LocalDate expiredDate = resultSet.getDate(6).toLocalDate();
                boolean isExpired = resultSet.getBoolean(7);
                product = new Product(id, price, name, description, createdDate, expiredDate, isExpired);
            } else {
                throw new RuntimeException("Product by id '" + id + "' not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        connect();
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int price = resultSet.getInt(2);
                String name = resultSet.getString(3);
                String description = resultSet.getString(4);
                LocalDate createdDate = resultSet.getDate(5).toLocalDate();
                LocalDate expiredDate = resultSet.getDate(6).toLocalDate();
                boolean isExpired = resultSet.getBoolean(7);
                products.add(new Product(id, price, name, description, createdDate, expiredDate, isExpired));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return products;
    }

    @Override
    public void deleteById(int id) {
        connect();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM products where product_id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    private static void connect(){
        try {
            connection = DriverManager.getConnection(URL);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
