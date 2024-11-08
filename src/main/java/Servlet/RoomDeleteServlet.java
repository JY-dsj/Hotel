package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RoomDeleteServlet")
public class RoomDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        // 获取要删除的记录的ID
        String recordId = request.getParameter("sid");

        // 连接数据库并删除记录
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dormitory", "root", "1234");
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM s_state WHERE sid = ?")) {

            stmt.setString(1, recordId);

            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted);
            if (rowsDeleted > 0) {
                response.getWriter().println("记录已删除");
                request.getRequestDispatcher("RoomListServlet" +
                        "").forward(request, response);

            } else {
                response.getWriter().println("记录删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}