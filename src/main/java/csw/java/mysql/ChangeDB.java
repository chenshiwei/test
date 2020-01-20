package csw.java.mysql;


import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.*;
import java.util.Random;

//http://my.oschina.net/Thinkeryjgfn/blog/177283
//http://www.cnblogs.com/I-will-be-different/p/3925351.html?utm_source=tuicool&utm_medium=referral
//java jdbc使用SSH隧道连接mysql数据库demo
public class ChangeDB {


    static int lport = 3306;//本地端口
    static String rhost = "192.168.0.206";//远程MySQL服务器
    static int rport = 3306;//远程MySQL服务端口

    public static void go() {
        String user = "root";//SSH连接用户名
        String password = "8Dqpt7mpHXY6I11a";//SSH连接密码
        String host = "47.110.58.11";//SSH服务器
        int port = 22;//SSH访问端口
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息
            int assinged_port = session.setPortForwardingL(lport, rhost, rport);
            System.out.println("localhost:" + assinged_port + " -> " + rhost + ":" + rport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sql() {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        Random random = new Random();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aiops_test", "dbuser", "DBuser123!");
            st = conn.createStatement();
            while(true) {
                String sql = "INSERT INTO stream_test (timestamp,value) VALUES (" + System.currentTimeMillis() + "," + random.nextDouble() + ")";
                st.executeUpdate(sql);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        go();
        sql();
    }

}