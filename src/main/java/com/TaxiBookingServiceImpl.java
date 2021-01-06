package com;

public class TaxiBookingServiceImpl implements TaxiBookingService {

    public void bookTaxi(final String source, final String destination, final int noOfTravellers) {
        validateInput(source, destination, noOfTravellers);

    }

    private void validateInput(String source, String destination, int noOfTravellers) {
        if (source == null) {
            throw new IllegalArgumentException("Invalid Source");
        }
        else if (destination == null) {
            throw new IllegalArgumentException("Invalid Destination");
        }
        else if (noOfTravellers <= 0) {
            throw new IllegalArgumentException("Invalid noOfTravellers");
        }
        else if( source.equalsIgnoreCase(destination)){
            throw new IllegalArgumentException("Same source and destination provided");
        }
    }
}
