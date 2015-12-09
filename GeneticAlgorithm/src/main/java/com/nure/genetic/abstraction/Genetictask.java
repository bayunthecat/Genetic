package com.nure.genetic.abstraction;

public interface GeneticTask {
    Chromosome solve(FitnessFunction fitnessFunction, Breeder breeder, Selection parentSelector, Selection populationSelector, Mutagen mutagen, Chromosome[] initPopulation);
}
