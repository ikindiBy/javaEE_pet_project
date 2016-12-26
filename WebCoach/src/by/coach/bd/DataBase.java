package by.coach.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	private static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/coachsite";
			con = DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
