package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoUtility {
	public static Connection getConnectionToPostGres() {
		Connection connection = null;
		String url = "jdbc:postgresql://localhost:5432/CaseStudySchool";
		try {
			connection = DriverManager.getConnection(url,"postgres","12345678");
			System.out.println("Successful Connection to PostGres ");
			
		} catch (SQLException e) {
			System.out.println("SQLException: not connection " + e.getMessage());

		}
		
		return connection;

	}
}
