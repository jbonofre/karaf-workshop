package net.nanthrax.karaf.workshop.web;

import net.nanthrax.karaf.workshop.common.Booking;
import net.nanthrax.karaf.workshop.common.BookingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class BookingServlet extends HttpServlet {

    private BookingService bookingService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<head><title>Booking</title></head>");
            writer.println("<body>");
            for (Booking booking : bookingService.list()) {
                writer.println("Booking " + booking.getId() + "<br/>");
                writer.println("&nbsp; &nbsp; &nbsp; Customer: " + booking.getCustomer() + "<br/>");
                writer.println("&nbsp; &nbsp; &nbsp; Flight: " + booking.getFlight() + "<br/>");
                writer.println("&nbsp; &nbsp; &nbsp; Status: " + booking.getStatus() + "<br/>");
            }
            writer.println("</body>");
            writer.println("</html>");
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

}
