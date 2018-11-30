package com.wy.tool;

import java.sql.*;
import java.util.Properties;

/**
 * database connection tool
 * Singleton Design Pattern
 */
public class JDBConnection {
    private Connection connection = null;
    private static JDBConnection instance = null;

    private JDBConnection() {
        try {
            ClassLoader cl = JDBConnection.class.getClassLoader();
            Properties pro = new Properties();
            pro.load(cl.getResourceAsStream("db/db.properties"));
            Class.forName((String) pro.get("driver"));
            connection = DriverManager.getConnection((String) pro.get("url"), (String) pro.get("user"), (String) pro.get("password")); // ݿ
        } catch (Exception ex) {
            System.out.println("failed to load database");
            ex.printStackTrace();
        }
    }

    /**
     * get the single instance of JDBConnection
     *
     * @return the JDBConnection instance
     */
    public static JDBConnection getInstance() {
        if (instance == null) {
            synchronized (JDBConnection.class) {
                if (instance == null) {
                    instance = new JDBConnection();
                }
            }
        }
        return instance;
    }

    /**
     * proxy of prepareStatement
     *
     * @param sql sql string
     * @return the PreparedStatement
     * @throws SQLException sql exception
     */
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return instance.connection.prepareStatement(sql);
    }

    /**
     * close the database connection
     *
     * @throws SQLException sql exception
     */
    public static void close() throws SQLException {
        if (instance != null) {
            instance.connection.close();
            instance = null;
        }
    }
}
