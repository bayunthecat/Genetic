package com.nure.genetic.implementation;


import com.nure.genetic.abstraction.*;

public class MyGeneticTask implements GeneticTask {

    private double epsilon;

    public MyGeneticTask(double epsilon) {
        this.epsilon = epsilon;
    }

    @Override
    public Chromosome solve(FitnessFunction fitnessFunction, Breeder breeder, Selection parentSelector, Selection populationSelector, Mutagen mutagen, Chromosome[] initPopulation) {

        return null;
    }

}
