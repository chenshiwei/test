package csw.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 * @author shiweichen
 * 
 */

public class JDBCUtil {

	private String url;
	private String username;
	private String password;
	private static Connection connection;
	private static JDBCUtil instance = null;

	public static JDBCUtil getInstance() {
		if (null == instance) {
			instance = new JDBCUtil();
		}
		return instance;
	}

	private JDBCUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.url = Constants.JDBC_URL;
		this.username = Constants.JDBC_USERNAME;
		this.password = Constants.JDBC_PASSWORD;
		try {
			connection = (Connection) DriverManager.getConnection(url,
					username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static boolean rollback() {
		return rollback(connection);
	}

	public static boolean rollback(Connection conn) {
		try {
			if (null != conn && !conn.isClosed()) {
				conn.rollback();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
		return false;
	}

	public boolean closeAll() {
		try {
			if ((null != connection && !connection.isClosed())) {
				connection.close();
				connection = null;
			}
			instance = null;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
}
