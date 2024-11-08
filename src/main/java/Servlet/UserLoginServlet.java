package Servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

/**
 * @author 2022
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String account = request.getParameter("account");
        String password = request.getParameter("password");
       /* System.out.println(username);
        System.out.println(password);*/

        String url = "jdbc:mysql://localhost:3306/dormitory";
        String user = "root";
        String passwordDb = "1234";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, passwordDb);

            String sql = "SELECT * FROM customer_login WHERE account = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account);
            rs = pstmt.executeQuery();

            String error;
            if (rs.next()) {
                // 用户名存在
                String dbPassword = rs.getString("password");
                if (dbPassword.equals(password)) {
                    // 密码正确，登录成功
                    HttpSession session = request.getSession();
                    session.setAttribute("account", account);

                    response.sendRedirect("UserHeaderServlet"); // 跳转到成功页面
                } else {
                    error = "密码错误，请重新输入";
                    // 密码错误
                    request.setAttribute("error",error);

                    request.getRequestDispatcher("user_login.jsp").forward(request, response);
                }
            } else {
                // 用户名不存在
                error = "用户名不存在";
                request.setAttribute("error", error);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
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