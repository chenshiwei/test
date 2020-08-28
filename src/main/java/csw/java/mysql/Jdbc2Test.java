package csw.java.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc2Test {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/evolution?useUnicode=true&characterEncoding=utf8&useSSL=false";
            String username = "dbuser";
            String password = "DBuser@123_!@#";
            Connection conn = (Connection) DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from ml_operator_group");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
