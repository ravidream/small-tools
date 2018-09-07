/*
 *
 */
package com.phoneon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ravi
 *
 */
public class DBConnection {

	String url = "jdbc:mysql://localhost:3306/phoneondb";
	String username = "root";
	String password = "ravi";

	public Connection getConnection() {

		Connection connection = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(url, username, password);
		}catch (ClassNotFoundException e) {
			throw new IllegalStateException("Driver Class not found.", e);
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
		return connection;
	}
}//end of the class
