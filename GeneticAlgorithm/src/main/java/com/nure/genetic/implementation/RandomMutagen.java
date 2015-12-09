package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.abstraction.Mutagen;

import java.util.Random;

public class RandomMutagen implements Mutagen {

    public static final double DEFAULT_CELL_MUTATION_PROBABILITY = 0.12;

    private double cellMutationProbabilty;

    private Random random;

    public RandomMutagen(double cellMutationProbability) {
        this.cellMutationProbabilty = checkProbability(cellMutationProbability, DEFAULT_CELL_MUTATION_PROBABILITY);
        random = new Random();
    }

    @Override
    public Chromosome mutate(Chromosome chromosome) {
        boolean[] values = chromosome.getBinaryValues();
        mutate(values);
        return new MyChromosome(values);
    }

    private double checkProbability(double cellMutationProbability, double defaultValue) {
        return cellMutationProbability <= 1.0 && cellMutationProbability >= 0.0 ? cellMutationProbability : defaultValue;
    }

    private void mutate(boolean[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextDouble() < cellMutationProbabilty;
        }
    }

}
