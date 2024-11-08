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
@WebServlet("/RoomEditServlet")
public class RoomEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid = request.getParameter("sid"); // 获取要修改的数据的jid

        System.out.println(sid);
        // 连接数据库
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dormitory", "root", "1234");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM s_state WHERE sid = ?")) {
            stmt.setString(1, sid);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // 从查询结果中获取原始数据
                String floor = rs.getString("floor");
                String features1 = rs.getString("features1");
                String features2 = rs.getString("features2");
                String state = rs.getString("state");

                // 将数据设置到request作用域中
                request.setAttribute("floor", floor);
                request.setAttribute("sid", sid);
                request.setAttribute("features1", features1);
                request.setAttribute("features2", features2);
                request.setAttribute("state", state);

                // 转发到编辑页面edit.jsp
                request.getRequestDispatcher("RoomEdit.jsp").forward(request, response);
            } else {
                response.getWriter().println("未找到数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}