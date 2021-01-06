package com;

import com.farecalculation.FareCalculationService;
import com.farecalculation.FareCalculationServiceImpl;
import com.geomap.GeoMapService;
import com.geomap.GeoMapServiceImpl;
import com.geomap.Graph;
import com.ticketprinting.TicketPrintingService;
import com.ticketprinting.TicketPrintingServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaxiBookingTest {

    private TaxiBookingService taxiBookingService;

    @Before
    public void setUp() {
        FareCalculationService fareCalculationService = new FareCalculationServiceImpl();
        Graph graph = new Graph();
        GeoMapService geoMapService= new GeoMapServiceImpl(graph);
        TicketPrintingService ticketPrintingService = new TicketPrintingServiceImpl();
        taxiBookingService = new TaxiBookingServiceImpl(geoMapService,fareCalculationService, ticketPrintingService);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullSource() {
        taxiBookingService.bookTaxi(null, "PUNE", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullDestination() {
        taxiBookingService.bookTaxi("PUNE", null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroTravellers() {
        taxiBookingService.bookTaxi("PUNE", "MUMBAI", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeTravellers() {
        taxiBookingService.bookTaxi("PUNE", "MUMBAI", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSameSourceAndDestination() {
        taxiBookingService.bookTaxi("PUNE", "PUNE", 1);
    }

    @Test
    public void testForPuneToNasik() {
        final String ticket = taxiBookingService.bookTaxi("PUNE", "NASIK", 2);
        String expectedTicket = "Taxi Ticket" + "\n"
                + "-----------" + "\n"
                + "Source: PUNE" + "\n"
                + "Destination: NASIK" + "\n"
                + "Kms: 200" + "\n"
                + "No. of travellers = 2" + "\n"
                + "Total = 2500 INR";
        Assert.assertEquals(expectedTicket, ticket);
    }

}
