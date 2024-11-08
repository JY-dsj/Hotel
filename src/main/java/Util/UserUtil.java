package Util;

import java.sql.*;

public class UserUtil {
    //加载数据库，并建立数据库连接。
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/dormitory?characterEncodeing=UTF-8&serverTimezone=GMT%2B8&useSSL=false";
        String name = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url,name,password) ;
        return conn;
    }
    //关闭数据库连接，释放资源
    public static void release(Statement stmt, Connection conn) {
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
    public static void release(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace() ;
            }
            rs = null;
        }
        release (stmt,conn);
    }
}
