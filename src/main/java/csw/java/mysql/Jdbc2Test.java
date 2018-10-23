package csw.java.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jdbc2Test {
    public static final String DATE_FORMAT_FOR_STAT = "yyyy-MM-dd";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.1.53.233:3306/ai?useUnicode=true&characterEncoding=utf8&useSSL=false";
            String username = "root";
            String password = "123456";
            Connection conn = (Connection) DriverManager.getConnection(url, username, password);


            StringBuilder sb = new StringBuilder();
            Random rand = new Random();
            List<Integer> statusList = new ArrayList<>();
            statusList.add(1);
            statusList.add(2);
            statusList.add(-1);
            statusList.add(-2);

            sb.append("INSERT INTO `baseline_labels`(object_id,TIMESTAMP,status) VALUES ");
            for (int i = 0; i < 10000; i++) {
                long hours = System.currentTimeMillis() / 3600000 - rand.nextInt(10000);
                sb.append("('trend").append(rand.nextInt(100)).append("',")
                        .append(hours * 3600000)
                        .append(",").append(statusList.get(rand.nextInt(statusList.size())))
                        .append("),");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            System.out.println(sb);
            conn.createStatement().executeUpdate(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public static String dateBeforeNowToString(int daysBeforeNow) {
    // Date date = new Date();
    // Calendar calendar = Calendar.getInstance();
    // calendar.setTime(date);
    // calendar.add(Calendar.DAY_OF_YEAR, -1 * daysBeforeNow);
    // return new
    // SimpleDateFormat(DATE_FORMAT_FOR_STAT).format(calendar.getTime());
    // }
}
