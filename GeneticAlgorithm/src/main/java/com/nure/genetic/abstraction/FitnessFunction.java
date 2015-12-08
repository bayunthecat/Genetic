package com.nure.genetic.abstraction;

@FunctionalInterface
public interface FitnessFunction {
    double getValue(double... xs);
}
