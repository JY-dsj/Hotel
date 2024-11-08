package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 2022
 */
@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jid = request.getParameter("jid"); // 获取要修改的数据的jid

        System.out.println(jid);
        // 连接数据库
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dormitory", "root", "1234");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM jiaogong WHERE jid = ?")) {
            stmt.setString(1, jid);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // 从查询结果中获取原始数据
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String sid = rs.getString("sid");
                String phone = rs.getString("phone");
                String account = rs.getString("account");
                String password = rs.getString("password");

                // 将数据设置到request作用域中
                request.setAttribute("jid", jid);
                request.setAttribute("name", name);
                request.setAttribute("sex", sex);
                request.setAttribute("sid", sid);
                request.setAttribute("phone", phone);
                request.setAttribute("account", account);
                request.setAttribute("password", password);

                // 转发到编辑页面edit.jsp
                request.getRequestDispatcher("UserEdit.jsp").forward(request, response);
            } else {
                response.getWriter().println("未找到数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}