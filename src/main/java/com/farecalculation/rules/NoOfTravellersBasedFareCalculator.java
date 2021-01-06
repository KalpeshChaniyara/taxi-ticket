package com.farecalculation.rules;

import com.farecalculation.FareCalculationParameters;

public class NoOfTravellersBasedFareCalculator implements FareCalculationRule {
    @Override
    public int calculate(int initialValue, FareCalculationParameters fareCalculationParameters) {
        final int fare = initialValue * fareCalculationParameters.getNoOfTravellers();
        return fare;
    }
}
