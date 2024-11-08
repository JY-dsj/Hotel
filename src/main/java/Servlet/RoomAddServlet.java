package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 2022
 */
@WebServlet("/RoomAddServlet")
public class RoomAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String floor = request.getParameter("floor");
        String sid = request.getParameter("sid");
        String features1 = request.getParameter("features1");
        String features2 = request.getParameter("features2");
        String state = request.getParameter("state");

        // 数据库连接信息（这里只是示例，实际开发中应该使用配置文件或环境变量）
        String url = "jdbc:mysql://localhost:3306/dormitory";
        String user = "root";
        String passwordDb = "1234";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, passwordDb);

            String sql = "SELECT * FROM s_state WHERE sid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sid);
            rs = pstmt.executeQuery();

            String error = null;
            if (rs.next()) {
                // 用户名存在
                error = "用户已存在！无需添加";
                request.setAttribute("error", error);

                request.getRequestDispatcher("/RoomListServlet").forward(request, response);

            } else {
                // 用户不存在
                PreparedStatement pstmt1 = conn.prepareStatement("INSERT INTO s_state (floor,sid,features1,features2,state) VALUES (?,?,?,?,?)");

                pstmt1.setString(1, floor);
                pstmt1.setString(2, sid);
                pstmt1.setString(3, features1);
                pstmt1.setString(4, features2);
                pstmt1.setString(5, state);
                int rowsAffected = pstmt1.executeUpdate();
                if (rowsAffected > 0) {
                    response.setContentType("text/html");
                }
                request.getRequestDispatcher("RoomListServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}

