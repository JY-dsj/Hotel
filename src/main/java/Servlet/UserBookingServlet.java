package Servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 2022
 */
@WebServlet("/UserBookingServlet")
public class UserBookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 获取表单提交的数据
        String jid = request.getParameter("jid");
        String sid = request.getParameter("sid");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String enterTime = request.getParameter("enterTime");
        String leaveTime = request.getParameter("leaveTime");
        String roomType = request.getParameter("roomType");

        // 数据库连接相关信息
        String url = "jdbc:mysql://localhost:3306/dormitory";
        String user = "root";
        String password = "1234";

        // JDBC 驱动名及数据库连接
        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);

            // 插入数据的 SQL 语句
            String sql = "INSERT INTO booking (jid, sid, name, phone, enterTime, leaveTime,roomType) VALUES (?,?,?, ?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, jid);
            pstmt.setString(2, sid);
            pstmt.setString(3, name);
            pstmt.setString(4, phone);
            pstmt.setString(5, enterTime);
            pstmt.setString(6, leaveTime);
            pstmt.setString(7, roomType);

            // 执行插入操作
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                request.getRequestDispatcher("Success.jsp").forward(request, response);
            }

            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("预订信息插入失败，请查看控制台错误信息");
        }
    }
}

