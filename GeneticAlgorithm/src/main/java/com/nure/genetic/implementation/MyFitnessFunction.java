package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.FitnessFunction;

public class MyFitnessFunction implements FitnessFunction {
    @Override
    public double getValue(double... xs) {
        double result = 0;
        for(double x : xs) {
            result += x;
        }
        return result;
    }
}
