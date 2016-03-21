package com.nure.genetic.implementation;


import com.nure.genetic.abstraction.*;
import com.nure.genetic.utils.NumericUtils;

import java.util.Arrays;

public class MyGeneticTask implements GeneticTask {

    private double epsilon;

    public MyGeneticTask(double epsilon) {
        this.epsilon = epsilon;
    }

    @Override
    public Chromosome solve(FitnessFunction fitnessFunction, BreedingContainer breeder, Selection parentSelector, Selection populationSelector, Mutagen mutagen, Chromosome[] initPopulation) {
        double currentValue = 0;
        double previousValue = Double.MIN_VALUE;
        System.out.println("Initial population: " + Arrays.toString(initPopulation));
        Chromosome[] currentPopulation = initPopulation;
        Chromosome bestChromosome = null;
        int generation = 0;
        while (Math.abs(currentValue - previousValue) < epsilon) {
            System.out.println("Generation ==> " + generation++);
            previousValue = currentValue;
            currentPopulation = parentSelector.select(fitnessFunction, currentPopulation);
            System.out.println("Parents to give new population:  " + Arrays.toString(currentPopulation));
            currentPopulation = breeder.getPopulation(currentPopulation);
            System.out.println("Descendants [Crossover complete] " + Arrays.toString(currentPopulation));
            currentPopulation = mutateAll(currentPopulation, mutagen);
            System.out.println("Descendants [Mutation complete] " + Arrays.toString(currentPopulation));
            currentPopulation = populationSelector.select(fitnessFunction, currentPopulation);
            System.out.println("Descendants [Crossover complete] " + Arrays.toString(currentPopulation));
            bestChromosome = getBestValue(fitnessFunction, currentPopulation);
        }
        System.out.println("And the winner is: " + bestChromosome);
        return bestChromosome;
    }

    private Chromosome[] mutateAll(Chromosome[] chromosomes, Mutagen mutagen) {
        for (int i = 0; i < chromosomes.length; i++) {
            chromosomes[i] = mutagen.mutate(chromosomes[i]);
        }
        return chromosomes;
    }

    private Chromosome getBestValue(FitnessFunction function, Chromosome[] chromosomes) {
        float max = 0;
        Chromosome best = chromosomes[0];
        for (Chromosome chromosome : chromosomes) {
            float current = function.getValue(chromosome.getValues());
            if (current > max) {
                max = current;
                best = chromosome;
            }
        }
        return best;
    }
}
