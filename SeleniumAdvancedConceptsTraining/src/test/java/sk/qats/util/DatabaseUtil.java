package sk.qats.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static Connection con;
	private static Statement statment;
	private static ResultSet resultSet;

	// dbURL in format : "jdbc:mysql://10.0.0.1/MYDB";
	public static void connectToDb(String dbUrl, String user, String pswd) throws ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
		try {
			con = DriverManager.getConnection(dbUrl, user, pswd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void disconnectFromDb() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void executeQuery(String query) {
		try {

			statment = con.createStatement();
			resultSet = statment.executeQuery(query);

			while (resultSet.next()) {
				// e.g. for colum with name 'column_name'
				System.out.println(resultSet.getString("column_name"));
				System.out.println(resultSet.getInt("ID"));
			}

			resultSet.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
