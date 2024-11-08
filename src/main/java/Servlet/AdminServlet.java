package Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println("error");

        String url = "jdbc:mysql://localhost:3306/dormitory";
        String user = "root";
        String passwordDb = "1234";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, passwordDb);

            String sql = "SELECT * FROM admin_login WHERE account = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account);
            rs = pstmt.executeQuery();

            String error = null;
            if (rs.next()) {
                // 用户名存在
                String dbPassword = rs.getString("password");
                if (dbPassword.equals(password)) {
                    // 密码正确，登录成功
                    response.sendRedirect("AdminListServlet"); // 跳转到成功页面
                } else {
                    error = "密码错误，请重新输入";
                    // 密码错误
                    request.setAttribute("error",error);
                    System.out.println("error");
                    request.getRequestDispatcher("Admin_login.jsp").forward(request, response);
                }
            } else {
                // 用户名不存在
                error = "用户名不存在";
                request.setAttribute("error", error);

                request.getRequestDispatcher("Admin_login.jsp").forward(request, response);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
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
}