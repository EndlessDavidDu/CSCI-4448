package com.wy.tool;

import java.sql.*;
import java.util.Properties;


public class JDBConnection {

    public Connection connection = null;


	public JDBConnection() {

		try {

			ClassLoader cl = JDBConnection.class.getClassLoader();
			Properties pro = new Properties();
			pro.load(cl.getResourceAsStream("db/db.properties"));

			Class.forName((String)pro.get("driver")); // 加载数据库驱动
			connection = DriverManager.getConnection((String)pro.get("url"), (String)pro.get("user"),(String)pro.get("password")); // 加载数据库
		} catch (Exception ex) {
			System.out.println("数据库加载失败");
			ex.printStackTrace();
		}
	}
	public static void main(String []args) {

        JDBConnection con = new JDBConnection();
        System.out.println(con);
    }
	
}
