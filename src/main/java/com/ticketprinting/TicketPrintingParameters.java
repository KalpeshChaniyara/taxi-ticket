package com.ticketprinting;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketPrintingParameters {
    private String source;
    private String destination;
    private int distance;
    private int fare;
    int noOfTravellers;
}
