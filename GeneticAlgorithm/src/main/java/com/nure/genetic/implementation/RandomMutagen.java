package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.abstraction.Mutagen;
import com.nure.genetic.utils.NumericUtils;

import java.util.Random;

import static com.nure.genetic.utils.NumericUtils.toBooleanArray;
import static com.nure.genetic.utils.NumericUtils.toFloatArray;

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
        return new MyChromosome(mutate(toBooleanArray(chromosome.getValues())));
    }

    private float[] mutate(boolean[] values) {
        boolean isMutant = random.nextDouble() < cellMutationProbability;
        if(isMutant) {
            for (int i = 1; i < values.length; i++) {
                isMutant = random.nextDouble() < cellMutationProbability;
                if(isMutant) {
                    values[i] = !values[i];
                }
            }
        }
        return toFloatArray(values);
    }

}
