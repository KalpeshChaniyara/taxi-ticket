package com.farecalculation;

import com.farecalculation.rules.DistanceBasedFareCalculator;
import com.farecalculation.rules.FareCalculationRule;
import com.farecalculation.rules.NoOfTravellersBasedFareCalculator;

import java.util.ArrayList;
import java.util.List;

public class FareCalculationServiceImpl implements FareCalculationService {

    private final List<FareCalculationRule> fareCalculationRuleList = new ArrayList<>();

    {
        fareCalculationRuleList.add(new DistanceBasedFareCalculator());
        fareCalculationRuleList.add(new NoOfTravellersBasedFareCalculator());
    }

    public int calculateFare(final FareCalculationParameters fareCalculationParameters) {
        int initialValue = 0;
        int fare = 0;
        for (FareCalculationRule fareCalculationRule : fareCalculationRuleList) {
            fare = fareCalculationRule.calculate(initialValue, fareCalculationParameters);
            initialValue = fare;
        }
        return fare;
    }
}
