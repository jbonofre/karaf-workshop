package net.nanthrax.karaf.workshop.command;

import net.nanthrax.karaf.workshop.common.Booking;
import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.commands.Option;

@Command(scope = "booking", name = "status", description = "Change or display the status of a booking")
public class StatusCommand extends BookingCommandSupport {

    @Argument(index = 0, name = "id", description = "Booking ID", required = true, multiValued = false)
    long id;

    @Option(name = "-c", aliases = { "--cancel" }, description = "Cancel the booking", required = false, multiValued = false)
    boolean cancel = false;

    @Option(name = "-cf", aliases = { "--confirm" }, description = "Confirm the booking", required = false, multiValued = false)
    boolean confirm = false;

    public Object doExecute() throws Exception {
        if (cancel) {
            getBookingService().cancel(id);
            System.out.println("Booking " + id + " has been canceled");
            return null;
        }
        if (confirm) {
            getBookingService().confirm(id);
            System.out.println("Booking " + id + " has been confirmed");
            return null;
        }
        Booking booking = getBookingService().get(id);
        if (booking != null) {
            System.out.println("Booking " + id + " is " + booking.getStatus());
        } else {
            System.err.println("Booking " + id + " not found");
        }
        return null;
    }

}
