package Servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String jid = request.getParameter("jid"); // 获取要修改数据的jid
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String sid = request.getParameter("sid");
        String phone = request.getParameter("phone");
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        // 更新数据库中的数据
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dormitory?useUnicode=true&characterEncoding=UTF-8", "root", "1234");
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE jiaogong SET name=?, sex=?, sid=?, phone=?, account=?, password=? WHERE jid = ?")) {
            stmt.setString(1, name);
            stmt.setString(2, sex);
            stmt.setString(3, sid);
            stmt.setString(4, phone);
            stmt.setString(5, account);
            stmt.setString(6, password);
            stmt.setString(7, jid);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                // 根据jid查询更新后的数据
                PreparedStatement queryStmt = conn.prepareStatement("SELECT * FROM jiaogong WHERE jid = ?");
                queryStmt.setString(1, jid);
                ResultSet rs = queryStmt.executeQuery();

                if (rs.next()) {
                    // 获取更新后的数据
                    String updatedJID = rs.getString("jid");
                    String updatedName = rs.getString("name");
                    String updatedSex = rs.getString("sex");
                    String updatedSid = rs.getString("sid");
                    String updatedPhone = rs.getString("phone");
                    String updatedAccount = rs.getString("account");
                    String updatedPassword = rs.getString("password");

                    // 设置更新后的数据到请求属性中
                    request.setAttribute("jid", updatedJID);
                    request.setAttribute("name", updatedName);
                    request.setAttribute("sex", updatedSex);
                    request.setAttribute("sid", updatedSid);
                    request.setAttribute("phone", updatedPhone);
                    request.setAttribute("account", updatedAccount);
                    request.setAttribute("password", updatedPassword);
                    // 转发到展示更新后的数据的页面
                    request.getRequestDispatcher("UserShow.jsp").forward(request, response);
                }
            } else {
                response.getWriter().println("数据更新失败");
                System.out.println("ccccc");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
