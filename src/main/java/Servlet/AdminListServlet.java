package Servlet;
import Service.StateService;
import bean.SState;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 2022
 */
@WebServlet("/AdminListServlet")
public class AdminListServlet extends HttpServlet {
    private StateService stateService;

    @Override
    public void init() throws ServletException {
        super.init();
        stateService = new StateService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SState> states = stateService.getAllUsers();
        request.setAttribute("states", states);
        request.getRequestDispatcher("/admainheader.jsp").forward(request, response);
    }
}
