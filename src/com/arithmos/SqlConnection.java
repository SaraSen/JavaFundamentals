package com.arithmos;

import java.sql.*;

import javax.swing.JOptionPane;

public class SqlConnection {

	
	public static Connection dbConnector() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/student";
            String user = "user";
            String password = "password";
            conn = (Connection) DriverManager.getConnection(url, user, password);
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
