package net.nanthrax.karaf.workshop.command;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;

@Command(scope = "booking", name = "delete", description = "Delete a booking")
public class DeleteCommand extends BookingCommandSupport {

    @Argument(index = 0, name = "id", description = "Booking id", required = true, multiValued = false)
    long id;

    public Object doExecute() throws Exception {
        getBookingService().delete(id);
        System.out.println("Booking " + id + " has been deleted");
        return null;
    }

}
