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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String jid = request.getParameter("jid");
        String name = request.getParameter("name");
        String sex = request.getParameter("gender");//----------
        String sid = request.getParameter("sid");
        String phone = request.getParameter("telephone");//------------
        String account = request.getParameter("account");
        String password = request.getParameter("password");

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

            String sql = "SELECT * FROM jiaogong WHERE jid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, jid);
            rs = pstmt.executeQuery();

            String error = null;
            if (rs.next()) {
                // 用户名存在
                error = "用户已存在,请登录！";
                request.setAttribute("error", error);

                request.getRequestDispatcher("user_login.jsp").forward(request, response);

            } else {
                // 用户不存在
                PreparedStatement pstmt1 = conn.prepareStatement("INSERT INTO jiaogong (jid,name,sex,sid,phone,account,password) VALUES (?,?,?,?,?,?,?)");

                pstmt1.setString(1, jid);
                pstmt1.setString(2, name);
                pstmt1.setString(3, sex);
                pstmt1.setString(4, sid);
                pstmt1.setString(5, phone);
                pstmt1.setString(6, account);
                pstmt1.setString(7, password);

                int rowsAffected = pstmt1.executeUpdate();
                if (rowsAffected > 0) {
                    response.setContentType("text/html");
                    /*PrintWriter out = response.getWriter();
                    out.println("<p>User registered successfully!</p>");*/
                }
                error = "注册成功,请登录！";
                request.setAttribute("error", error);

                request.getRequestDispatcher("user_login.jsp").forward(request, response);
            }


        } catch (Exception e) {
            e.printStackTrace();
            /*response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<p>Error: " + e.getMessage() + "</p>");*/
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
}

