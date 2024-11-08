package Servlet;

import bean.SState;

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
@WebServlet("/UserHeaderSearchServlet")
public class UserHeaderSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchInput = request.getParameter("searchInput");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<SState> sStateList = new ArrayList<>();

        try {
            // 1. 加载数据库驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 连接数据库
            String url = "jdbc:mysql://localhost:3306/dormitory";
            String username = "root";
            String password = "1234";
            conn = DriverManager.getConnection(url, username, password);

            // 3. 创建SQL语句并执行查询
            String sql = "SELECT floor, sid, features1, features2, state FROM s_state " +
                    "WHERE sid LIKE ? OR features1 LIKE ? OR features2 LIKE ? OR state LIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + searchInput + "%"); // sid
            stmt.setString(2, "%" + searchInput + "%"); // features1
            stmt.setString(3, "%" + searchInput + "%"); // features2
            stmt.setString(4, "%" + searchInput + "%"); // state
            rs = stmt.executeQuery();

            // 4. 处理查询结果
            while (rs.next()) {
                int floor = rs.getInt("floor");
                int sid = rs.getInt("sid");
                String features1 = rs.getString("features1");
                String features2 = rs.getString("features2");
                String state = rs.getString("state");
                SState sState = new SState(floor, sid, features1, features2, state);
                sStateList.add(sState);
            }
            System.out.println("查询结果：" + sStateList);
            // 5. 将结果存储到request属性中，转发到JSP页面
            request.setAttribute("sStateList", sStateList);
            request.getRequestDispatcher("/UserHeaderResult.jsp").forward(request, response);

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