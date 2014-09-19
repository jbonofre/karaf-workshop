package net.nanthrax.karaf.workshop.camel;

import net.nanthrax.karaf.workshop.common.Booking;
import net.nanthrax.karaf.workshop.common.BookingService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class BookingProcessor implements Processor {

    private BookingService bookingService;

    public void process(Exchange exchange) throws Exception {
        StringBuilder builder = new StringBuilder();
        for (Booking booking : bookingService.list()) {
            builder.append("ID: ").append(booking.getId())
                    .append("Customer: ").append(booking.getCustomer())
                    .append("flight: ").append(booking.getFlight())
                    .append("status: ").append(booking.getStatus());
            builder.append("\n");
        }

        exchange.getIn().setBody(builder.toString(), String.class);
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }
}
