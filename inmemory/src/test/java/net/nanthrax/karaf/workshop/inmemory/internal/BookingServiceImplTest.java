package net.nanthrax.karaf.workshop.inmemory.internal;

import static org.junit.Assert.*;

import net.nanthrax.karaf.workshop.common.Booking;
import net.nanthrax.karaf.workshop.common.BookingService;
import org.junit.Test;

public class BookingServiceImplTest {

    @Test
    public void testAddList() throws Exception {
        BookingService bookingService = new BookingServiceImpl();
        Booking booking = new Booking("test", "test");
        assertNotNull(booking.getId());
        assertEquals("WAITING", booking.getStatus());
        bookingService.add(booking);
        assertEquals(1, bookingService.list().size());
        assertNotNull(bookingService.get(booking.getId()));
    }

    @Test(expected=IllegalStateException.class)
    public void testDelete() throws Exception {
        BookingService bookingService = new BookingServiceImpl();
        Booking first = new Booking("test", "test");
        Booking second = new Booking("other", "other", "confirm");
        bookingService.add(first);
        bookingService.add(second);
        assertEquals(2, bookingService.list().size());
        bookingService.delete(first.getId());
        assertEquals(1, bookingService.list().size());
        bookingService.delete(second.getId());
    }

}
