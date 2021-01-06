package com.farecalculation.rules;

import com.farecalculation.FareCalculationParameters;

public class DistanceBasedFareCalculator implements FareCalculationRule{
    @Override
    public int calculate(int initialValue, FareCalculationParameters fareCalculationParameters) {
        int distance = fareCalculationParameters.getDistance();
        int fare = initialValue;
        if (distance >= 100) {
            fare += 750;
            distance = distance - 100;
        }
        if (distance > 0) {
            fare += distance * 5;
        }
        return fare;
    }
}
