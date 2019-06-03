package csw.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelperUtil {

    private String url;
    private String username;
    private String password;
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static DBHelperUtil instance = null;

    public static DBHelperUtil getInstance() {
        if (null == instance) {
            instance = new DBHelperUtil();
        }
        return instance;
    }

    private DBHelperUtil() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.url = "jdbc:mysql://localhost:3306/test";
        this.username = "root";
        this.password = "123456";
        try {
            connection = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        preparedStatement = null;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean rollback() {
        return rollback(connection);
    }

    public boolean rollback(Connection conn) {
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

    public static void closeAll() throws SQLException {
        if (null != preparedStatement) {
            preparedStatement.close();
            preparedStatement = null;
        }
        if ((null != connection && !connection.isClosed())) {
            connection.close();
            connection = null;
        }
        instance = null;
    }
}
