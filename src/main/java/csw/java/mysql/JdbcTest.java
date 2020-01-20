package csw.java.mysql;

import csw.java.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

    public static void main(String[] args) {
        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = jdbc.getConnection();

        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM test");
            while (rs.next()) {
                System.out.println(rs.getString(1) + ":" + rs.getString(2));
                break;
            }
            jdbc.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
