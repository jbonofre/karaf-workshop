package net.nanthrax.karaf.workshop.command.completer;

import net.nanthrax.karaf.workshop.common.Booking;
import net.nanthrax.karaf.workshop.common.BookingService;
import org.apache.karaf.shell.console.Completer;
import org.apache.karaf.shell.console.completer.StringsCompleter;

import java.util.List;

public class BookingCompleter implements Completer {

    private BookingService bookingService;

    public int complete(String buffer, int cursor, List<String> candidates) {
        StringsCompleter delegate = new StringsCompleter();
        for (Booking booking : bookingService.list()) {
            delegate.getStrings().add(Long.toString(booking.getId()));
        }
        return delegate.complete(buffer, cursor, candidates);
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }
}
