package com.farecalculation.rules;

import com.farecalculation.FareCalculationParameters;

@FunctionalInterface
public interface FareCalculationRule {

    int calculate(int initialValue, FareCalculationParameters fareCalculationParameters);
}
