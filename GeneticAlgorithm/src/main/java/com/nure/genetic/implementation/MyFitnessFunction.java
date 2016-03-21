package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.FitnessFunction;

public class MyFitnessFunction implements FitnessFunction {
    @Override
    public float getValue(float... xs) {
        return  - xs[0] * xs[0] - 2 * xs[0] + 3;
    }
}
