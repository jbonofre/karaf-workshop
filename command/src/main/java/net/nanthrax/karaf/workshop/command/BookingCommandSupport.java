package net.nanthrax.karaf.workshop.command;

import net.nanthrax.karaf.workshop.common.BookingService;
import org.apache.karaf.shell.console.OsgiCommandSupport;

public abstract class BookingCommandSupport extends OsgiCommandSupport {

    private BookingService bookingService;

    public abstract Object doExecute() throws Exception;

    public BookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

}
