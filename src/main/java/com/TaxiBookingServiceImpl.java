package com;

import com.farecalculation.FareCalculationParameters;
import com.farecalculation.FareCalculationService;
import com.geomap.GeoMapService;
import com.ticketprinting.TicketPrintingParameters;
import com.ticketprinting.TicketPrintingService;

public class TaxiBookingServiceImpl implements TaxiBookingService {

    private final GeoMapService geoMapService;
    private final FareCalculationService fareCalculationService;
    private final TicketPrintingService ticketPrintingService;

    public TaxiBookingServiceImpl(GeoMapService geoMapService,
                                  FareCalculationService fareCalculationService,
                                  TicketPrintingService ticketPrintingService) {
        this.geoMapService = geoMapService;
        this.fareCalculationService = fareCalculationService;
        this.ticketPrintingService = ticketPrintingService;
    }

    public String bookTaxi(final String source, final String destination, final int noOfTravellers) {
        validateInput(source, destination, noOfTravellers);
        int distance = geoMapService.findDistance(source, destination);
        final int fare = fareCalculationService.calculateFare(FareCalculationParameters.builder()
                .distance(distance)
                .noOfTravellers(noOfTravellers)
                .build());
        final String ticket = ticketPrintingService.printTicket(
                TicketPrintingParameters.builder()
                        .source(source)
                        .destination(destination)
                        .distance(distance)
                        .fare(fare)
                        .noOfTravellers(noOfTravellers)
                        .build());
        return ticket;
    }

    private void validateInput(String source, String destination, int noOfTravellers) {
        if (source == null) {
            throw new IllegalArgumentException("Invalid Source");
        } else if (destination == null) {
            throw new IllegalArgumentException("Invalid Destination");
        } else if (noOfTravellers <= 0) {
            throw new IllegalArgumentException("Invalid noOfTravellers");
        } else if (source.equalsIgnoreCase(destination)) {
            throw new IllegalArgumentException("Same source and destination provided");
        }
    }
}
