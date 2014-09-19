package net.nanthrax.karaf.workshop.common;

import java.util.List;

public interface BookingService {

    public List<Booking> list();

    public Booking get(Long id);

    public void add(Booking booking);

    public void confirm(Long id) throws Exception;

    public void cancel(Long id) throws Exception;

    public void delete(Long id) throws Exception;

}
