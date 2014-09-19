package net.nanthrax.karaf.workshop.command;

import net.nanthrax.karaf.workshop.common.Booking;
import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;

@Command(scope = "booking", name = "add", description = "Add a new booking")
public class AddCommand extends BookingCommandSupport {

    @Argument(index = 0, name = "customer", description = "The booking customer name", required = true, multiValued = false)
    String customer;

    @Argument(index = 1, name = "flight", description = "The booking flight", required = true, multiValued = false)
    String flight;

    @Argument(index = 2, name = "status", description = "The booking status", required = false, multiValued = false)
    String status;

    public Object doExecute() throws Exception {
        if (status != null) {
            Booking booking = new Booking(customer, flight, status);
            getBookingService().add(booking);
        } else {
            Booking booking = new Booking(customer, flight);
            getBookingService().add(booking);
        }
        return null;
    }

}
