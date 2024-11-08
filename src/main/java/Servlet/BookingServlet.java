package Servlet;
        import Dao.BookingDAO;
        import bean.Booking;

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
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    private BookingDAO bookingDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        bookingDAO = new BookingDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Booking> bookings = bookingDAO.getAllUsers();
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("/Booking.jsp").forward(request, response);
    }

}
