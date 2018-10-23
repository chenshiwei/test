package csw.java.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import csw.java.util.JDBCUtil;

public class JdbcTest {

	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		Connection conn = jdbc.getConnection();
		
		try {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM user_info");
			while (rs.next()) {
				System.out.println(rs.getString(1) + ":" + rs.getString(2));
			}
			jdbc.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
