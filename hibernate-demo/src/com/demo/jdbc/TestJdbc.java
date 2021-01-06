package com.demo.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = null;
		String user = null;
		String pass = null;
		
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src/jdbc.properties"));
			jdbcUrl = (String) properties.get("jdbc.connection.url");
			user = (String) properties.get("jdbc.connection.username");
			pass = (String) properties.get("jdbc.connection.password");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!");
		} catch (Exception e ) {
			e.printStackTrace();
		}
	}

}
