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

@WebServlet("/RoomUpdateServlet")
public class RoomUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String floor = request.getParameter("floor");
        String sid = request.getParameter("sid");
        String features1 = request.getParameter("features1");
        String features2 = request.getParameter("features2");
        String state = request.getParameter("state");
        System.out.println(state);

        // 更新数据库中的数据
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dormitory?useUnicode=true&characterEncoding=UTF-8", "root", "1234");
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE s_state SET floor=?, features1=?, features2=?, state=? WHERE sid = ?")) {
            stmt.setString(1, floor);
            stmt.setString(2, features1);
            stmt.setString(3, features2);
            stmt.setString(4, state);
            stmt.setString(5, sid);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                // 根据jid查询更新后的数据
                PreparedStatement queryStmt = conn.prepareStatement("SELECT * FROM s_state WHERE sid = ?");
                queryStmt.setString(1, sid);
                ResultSet rs = queryStmt.executeQuery();

                if (rs.next()) {
                    // 获取更新后的数据
                    String updatedSID = rs.getString("sid");
                    String updatedFloor = rs.getString("floor");
                    String updatedFeatures1 = rs.getString("features1");
                    String updatedFeatures2 = rs.getString("features2");
                    String updatedState = rs.getString("state");

                    // 设置更新后的数据到请求属性中
                    request.setAttribute("sid", updatedSID);
                    request.setAttribute("floor", updatedFloor);
                    request.setAttribute("features1", updatedFeatures1);
                    request.setAttribute("features2", updatedFeatures2);
                    request.setAttribute("state", updatedState);

                    // 转发到展示更新后的数据的页面
                    request.getRequestDispatcher("RoomShow.jsp").forward(request, response);
                }
            } else {
                response.getWriter().println("数据更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
