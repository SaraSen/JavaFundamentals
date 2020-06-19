package com.arithmos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class DB {
	private static Connection c;

	public static void createMyConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/arithmos", "root", "");
	}

	public static void iud(String sql) throws Exception {
		if (c == null) {
			createMyConnection();
		}
		c.createStatement().executeUpdate(sql);
	}

	public static ResultSet search(String sql) throws Exception {
		if (c == null) {
			createMyConnection();
		}
		return c.createStatement().executeQuery(sql);

	}

	public static Connection getMyConnection() throws Exception {
		if (c == null) {
			createMyConnection();
		}
		return c;
	}
}
