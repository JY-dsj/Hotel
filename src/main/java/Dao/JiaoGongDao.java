package Dao;

import bean.Jiaogong;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 2022
 */
public class JiaoGongDao {
    // 数据库连接相关信息，根据你的实际情况修改
    private static final String URL = "jdbc:mysql://localhost:3306/dormitory";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    // 获取所有用户的方法
    public List<Jiaogong> getAllUsers() {
        List<Jiaogong> jiaogongs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 建立数据库连接
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 3. 准备 SQL 查询语句
            String sql = "SELECT * FROM jiaogong";
            statement = connection.prepareStatement(sql);

            // 4. 执行查询，获取结果集
            resultSet = statement.executeQuery();

            // 5. 处理结果集，将数据封装成 SState 对象并加入列表
            while (resultSet.next()) {

                int jid = resultSet.getInt("jid");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                int sid = resultSet.getInt("sid");
                String phone = resultSet.getString("phone");
                String account = resultSet.getString("account");
                String password = resultSet.getString("password");
                Jiaogong jiaogongObj = new Jiaogong(jid,name,sex,sid,phone,account,password);
                jiaogongs.add(jiaogongObj);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // 在实际应用中，应该进行适当的异常处理
        } finally {
            // 6. 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return jiaogongs;
    }
}
