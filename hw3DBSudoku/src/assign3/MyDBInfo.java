package assign3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * CS108 Student: This file will be replaced when we test your code. So, do not add any of your
 * assignment code to this file. Also, do not modify the public interface of this file.
 * Only change the public MyDBInfo constants so that it works with the database login credentials 
 * that we emailed to you.
 */
public class MyDBInfo {

	public static final String MYSQL_USERNAME = "cs108user";
	public static final String MYSQL_PASSWORD = "cs108pass";
	public static final String MYSQL_DATABASE_SERVER = "localhost";
	public static final String MYSQL_DATABASE_NAME = "cs108";

	private static Connection con;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + MYSQL_DATABASE_SERVER + "/"
					+ MYSQL_DATABASE_NAME;
			con = DriverManager.getConnection(url, MYSQL_USERNAME,
					MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err
					.println("CS108 student: Update the MySQL constants to correct values!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err
					.println("CS108 student: Add the MySQL jar file to your build path!");
		}
	}

	public static Connection getConnection() {
		return con;
	}

	public static void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
