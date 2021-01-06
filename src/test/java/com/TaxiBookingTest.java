package com;

import org.junit.Before;
import org.junit.Test;

public class TaxiBookingTest {

    private TaxiBookingService taxiBookingService;

    @Before
    public void setUp() throws Exception {
        taxiBookingService = new TaxiBookingServiceImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullSource() {
        taxiBookingService.bookTaxi(null,"PUNE",1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullDestination() {
        taxiBookingService.bookTaxi("PUNE",null,1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testZeroTravellers() {
        taxiBookingService.bookTaxi("PUNE","MUMBAI",0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeTravellers() {
        taxiBookingService.bookTaxi("PUNE","MUMBAI",-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSameSourceAndDestination() {
        taxiBookingService.bookTaxi("PUNE","PUNE",1);
    }
}
