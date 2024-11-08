package Servlet;

import bean.Jiaogong;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyselfNewServlet")
public class MyselfNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if(session != null){
            String account = (String) session.getAttribute("account");
            System.out.println(account);


        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Jiaogong> jiaogongList = new ArrayList<>();

        try {
            // 1. 加载数据库驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 连接数据库
            String url = "jdbc:mysql://localhost:3306/dormitory";
            String username = "root";
            String password1 = "1234";
            conn = DriverManager.getConnection(url, username, password1);

            // 3. 创建SQL语句并执行查询
            String sql = "SELECT jid, name, sex, sid, phone, account, password FROM jiaogong WHERE account = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, account) ;
            rs = stmt.executeQuery();

            // 4. 处理查询结果
            while (rs.next()) {
                int jid = rs.getInt("jid");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int sid = rs.getInt("sid");
                String phone = rs.getString("phone");
                String password = rs.getString("password");

                Jiaogong jiaogong = new Jiaogong(jid, name, sex, sid, phone, account, password);
                jiaogongList.add(jiaogong);
            }

            // 5. 将结果存储到request属性中，转发到JSP页面
            request.setAttribute("jiaogongList", jiaogongList);
            request.getRequestDispatcher("/profile.jsp").forward(request, response);

        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // 处理异常情况
        } finally {
            // 6. 关闭连接
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
