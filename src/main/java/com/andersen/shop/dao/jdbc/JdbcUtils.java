package com.andersen.shop.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
