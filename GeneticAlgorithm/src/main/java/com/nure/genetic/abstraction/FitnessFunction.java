package com.nure.genetic.abstraction;

@FunctionalInterface
public interface FitnessFunction {
    float getValue(float... xs);
}
