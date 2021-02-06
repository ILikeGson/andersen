package com.andersen.shop.dao;

import com.andersen.shop.Product;
import com.andersen.shop.dao.jdbc.JdbcUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BucketDaoImpl implements BucketDao{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/shop?user=root&password=password";
    private static Connection connection;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addProductToUserBucketById(int userId, int id) {
        connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO bucket VALUES (?, ?)");
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    @Override
    public List<Product> getAll(int userId) {
        connect();
        List<Product> productsInTheBucket = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *  FROM bucket WHERE bucket_id = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM products where product_id = ?");
                statement.setInt(1, resultSet.getInt(2));
                ResultSet resultSet1 = statement.executeQuery();
                if (resultSet1.next()) {
                    int id = resultSet1.getInt(1);
                    int price = resultSet1.getInt(2);
                    String name = resultSet1.getString(3);
                    String description = resultSet1.getString(4);
                    LocalDate createdDate = resultSet1.getDate(5).toLocalDate();
                    LocalDate expiredDate = resultSet1.getDate(6).toLocalDate();
                    boolean isExpired = resultSet1.getBoolean(7);
                    productsInTheBucket.add(new Product(id, price, name, description, createdDate, expiredDate, isExpired));
                } else {
                    throw new RuntimeException("Product by id '" + resultSet1.getInt(2) + "' not found");
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return productsInTheBucket;
    }

    @Override
    public void removeProductById(int userId, int id) {
        connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM bucket WHERE bucket_id = ? AND product_id = ?");
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
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
