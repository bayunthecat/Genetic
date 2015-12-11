package com.nure.genetic.abstraction;

import com.nure.genetic.implementation.BreedingContainer;

public interface GeneticTask {
    Chromosome solve(FitnessFunction fitnessFunction, BreedingContainer breeder, Selection parentSelector, Selection populationSelector, Mutagen mutagen, Chromosome[] initPopulation);
}

