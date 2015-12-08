package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.abstraction.Mutagen;

public class RandomMutagen implements Mutagen {

    public static final double DEFAULT_CELL_MUTATION_PROBABILITY = 0.12;

    public RandomMutagen(double cellMutationProbability) {
        checkProbability(cellMutationProbability, DEFAULT_CELL_MUTATION_PROBABILITY);
    }

    @Override
    public Chromosome mutate(Chromosome chromosome) {
        
        return null;
    }

    private double checkProbability(double cellMutationProbability, double defaultValue) {
        return cellMutationProbability <= 1.0 && cellMutationProbability >= 0.0 ? cellMutationProbability : defaultValue;
    }

}
