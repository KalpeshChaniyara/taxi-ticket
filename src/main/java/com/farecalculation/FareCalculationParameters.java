package com.farecalculation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FareCalculationParameters {
    private int distance;
    private int noOfTravellers;
}
