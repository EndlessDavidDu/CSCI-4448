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

			Class.forName((String)pro.get("driver")); // �������ݿ�����
			connection = DriverManager.getConnection((String)pro.get("url"), (String)pro.get("user"),(String)pro.get("password")); // �������ݿ�
		} catch (Exception ex) {
			System.out.println("���ݿ����ʧ��");
			ex.printStackTrace();
		}
	}
	public static void main(String []args) {

        JDBConnection con = new JDBConnection();
        System.out.println(con);
    }
	
}
