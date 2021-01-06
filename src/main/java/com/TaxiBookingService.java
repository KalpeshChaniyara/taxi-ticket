package com;

public interface TaxiBookingService {
    /**
     *
     * @param source source city
     * @param destination destination city
     * @param noOfTravellers no of travellers
     * @return ticket
     */
    String bookTaxi(String source, String destination, int noOfTravellers);
}
