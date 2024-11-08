package Servlet;

import bean.Jiaogong;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 2022
 */
@WebServlet("/JiaogongSearchServlet")
public class JiaogongSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchInput = request.getParameter("searchInput");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        System.out.println(searchInput);

        List<Jiaogong> jiaogongList = new ArrayList<>();

        try {
            // 1. 加载数据库驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 连接数据库
            String url = "jdbc:mysql://localhost:3306/dormitory";
            String username = "root";
            String password1 = "1234";
            conn = DriverManager.getConnection(url, username, password1);

            // 3. 创建SQL语句并执行查询
            String sql = "SELECT * FROM jiaogong  " +
                    "WHERE jid LIKE ? OR name LIKE ? OR sex LIKE ? OR sid LIKE ? OR phone LIKE ?  OR account LIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + searchInput + "%");
            stmt.setString(2, "%" + searchInput + "%");
            stmt.setString(3, "%" + searchInput + "%");
            stmt.setString(4, "%" + searchInput + "%");
            stmt.setString(5, "%" + searchInput + "%");
            stmt.setString(6, "%" + searchInput + "%");

            rs = stmt.executeQuery();

            // 4. 处理查询结果
            while (rs.next()) {

                int jid = rs.getInt("jid");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int sid = rs.getInt("sid") ;
                String phone = rs.getString("phone");
                String account = rs.getString("account");
                String password = rs.getString("password");

                Jiaogong jiaogong = new Jiaogong(jid, name, sex, sid, phone, account, password);
                jiaogongList.add(jiaogong);

            }
            System.out.println("查询结果：" + jiaogongList);
            // 5. 将结果存储到request属性中，转发到JSP页面
            request.setAttribute("jiaogongList", jiaogongList);
            request.getRequestDispatcher("/UserSearchResult.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // 处理异常情况
        } finally {
            // 6. 关闭连接
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);
    }
}

