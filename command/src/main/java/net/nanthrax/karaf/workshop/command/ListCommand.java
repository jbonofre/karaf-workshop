package net.nanthrax.karaf.workshop.command;

import net.nanthrax.karaf.workshop.common.Booking;
import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.table.ShellTable;

import java.util.List;

@Command(scope = "booking", name = "list", description = "List bookings")
public class ListCommand extends BookingCommandSupport {

    public Object doExecute() throws Exception {
        ShellTable table = new ShellTable();

        table.column("ID");
        table.column("Customer");
        table.column("Flight");
        table.column("Status");

        List<Booking> bookings = getBookingService().list();
        for (Booking booking : bookings) {
            table.addRow().addContent(booking.getId(), booking.getCustomer(), booking.getFlight(), booking.getStatus());
        }

        table.print(System.out);

        return null;
    }

}
