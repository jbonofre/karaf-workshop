package net.nanthrax.karaf.workshop.inmemory.internal;

import net.nanthrax.karaf.workshop.common.BookingService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Dictionary;
import java.util.Properties;

public class Activator implements BundleActivator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Activator.class);

    private BookingServiceImpl bookingServiceImpl;
    private ServiceRegistration serviceRegistration;

    public void start(BundleContext bundleContext) throws Exception {
        LOGGER.info("Starting InMemory bundle");
        LOGGER.debug("Creating BookingService");
        bookingServiceImpl = new BookingServiceImpl();
        LOGGER.debug("Registering BookingService");
        Dictionary dictionary = new Properties();
        dictionary.put("service.exported.interfaces", "*");
        serviceRegistration =
                bundleContext.registerService(BookingService.class, bookingServiceImpl, dictionary);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        LOGGER.info("Stopping InMemory bundle");
        if (serviceRegistration != null) {
            LOGGER.debug("Unregistering BookingService");
            serviceRegistration.unregister();
        }
    }

}
