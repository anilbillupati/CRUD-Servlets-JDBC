package com.updateServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	protected static Connection DBConnectionEstablished() throws ClassNotFoundException, SQLException {

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/company";
		String dbUsername = "root";
		String Password = "Nani@1902";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, dbUsername, Password);
		return con;

	}

}
