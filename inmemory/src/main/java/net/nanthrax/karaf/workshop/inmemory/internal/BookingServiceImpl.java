package net.nanthrax.karaf.workshop.inmemory.internal;

import net.nanthrax.karaf.workshop.common.Booking;
import net.nanthrax.karaf.workshop.common.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final static Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);

    private List<Booking> bookings = new LinkedList<Booking>();

    public List<Booking> list() {
        LOGGER.debug("Get bookings");
        return this.bookings;
    }

    public Booking get(Long id) {
        LOGGER.debug("Looking for booking {} ...", id);
        for (Booking booking : bookings) {
            if (booking.getId().longValue() == id.longValue()) {
                LOGGER.debug("Booking {} found", id);
                return booking;
            }
        }
        LOGGER.debug("Booking {} not found");
        return null;
    }

    public void add(Booking booking) {
        LOGGER.debug("Add booking {}", booking.getId());
        bookings.add(booking);
    }

    public void confirm(Long id) throws Exception {
        LOGGER.debug("Confirm booking {}", id);
        Booking booking = this.get(id);
        if (booking == null) {
            LOGGER.error("Booking {} is not found", id);
            throw new IllegalArgumentException("Booking " + id + " is not found");
        }
        if (booking.getStatus().equalsIgnoreCase("confirm")) {
            LOGGER.error("Booking {} is already confirmed", id);
            throw new IllegalStateException("Booking " + id + " is already confirmed");
        }
        booking.setStatus("CONFIRM");
    }

    public void cancel(Long id) throws Exception {
        LOGGER.debug("Cancel booking {}", id);
        Booking booking = this.get(id);
        if (booking == null) {
            LOGGER.error("Booking {} is not found", id);
            throw new IllegalArgumentException("Booking " + id + " is not found");
        }
        if (booking.getStatus().equalsIgnoreCase("cancel")) {
            LOGGER.error("Booking {} is already canceled", id);
            throw new IllegalStateException("Booking " + id + " is already canceled");
        }
        booking.setStatus("CANCEL");
    }

    public void delete(Long id) throws Exception {
        LOGGER.debug("Delete booking {}", id);
        Booking booking = this.get(id);
        if (booking == null) {
            LOGGER.error("Booking {} is not found", id);
            throw new IllegalArgumentException("Booking " + id + " is not found");
        }
        if (booking.getStatus().equalsIgnoreCase("confirm")) {
            LOGGER.error("Booking {} is confirmed, can't delete it", id);
            throw new IllegalStateException("Booking " + id + " is confirmed, can't delete it");
        }
        bookings.remove(booking);
    }

}
