package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.FitnessFunction;

public class MyFitnessFunction implements FitnessFunction {
    @Override
    public double getValue(double... xs) {
        return  - xs[0] * xs[0] - 2 * xs[0] + 3;
    }
}
