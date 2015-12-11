package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.abstraction.Mutagen;
import com.nure.genetic.utils.NumericUtils;

import java.util.Random;

public class RandomMutagen implements Mutagen {

    public static final double DEFAULT_CELL_MUTATION_PROBABILITY = 0.12;

    private double cellMutationProbability;

    private Random random;

    public RandomMutagen(double cellMutationProbability) {
        this.cellMutationProbability = NumericUtils.checkProbability(cellMutationProbability, DEFAULT_CELL_MUTATION_PROBABILITY);
        random = new Random();
    }

    @Override
    public Chromosome mutate(Chromosome chromosome) {
        boolean[] values = null;
        mutate(values);
        return new MyChromosome(null);
    }

    private void mutate(boolean[] values) {
        boolean isMutant = random.nextDouble() < cellMutationProbability;
        if(isMutant) {
            for (int i = 0; i < values.length; i++) {
                isMutant = random.nextDouble() < cellMutationProbability;
                if(isMutant) {
                    values[i] = !values[i];
                }
            }
        }
    }

}
