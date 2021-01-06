package com.ticketprinting;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TicketPrintingServiceImpl implements TicketPrintingService {

    private String ticketTemplate;
    {
        try {
            final Path templatePath = Paths.get(getClass().getResource("/ticketTemplate.txt").toURI());
            ticketTemplate = new String(Files.readAllBytes(templatePath));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public String printTicket(TicketPrintingParameters ticketPrintingParameters) {
        String ticket = ticketTemplate.replace("#{source}", ticketPrintingParameters.getSource());
        ticket = ticket.replace("#{destination}",ticketPrintingParameters.getDestination());
        ticket = ticket.replace("#{distance}",String.valueOf(ticketPrintingParameters.getDistance()));
        ticket = ticket.replace("#{fare}",String.valueOf(ticketPrintingParameters.getFare()));
        ticket = ticket.replace("#{noOfTravellers}",String.valueOf(ticketPrintingParameters.getNoOfTravellers()));
        return ticket;
    }
}
