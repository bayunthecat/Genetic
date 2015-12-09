package com.nure.genetic;

import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.implementation.BreedingContainer;
import com.nure.genetic.implementation.MyChromosome;

import java.util.Arrays;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        Chromosome ch1 = getRandomChromosome(5, 16);
        Chromosome ch2 = getRandomChromosome(5, 16);
        Chromosome ch3 = getRandomChromosome(5, 16);
        Chromosome ch4 = getRandomChromosome(5, 16);
        Chromosome ch5 = getRandomChromosome(5, 16);
        Chromosome[] chromosomes = {ch1, ch2, ch3, ch4, ch5};
        BreedingContainer container = new BreedingContainer();
        Chromosome[] population = container.getPopulation(chromosomes);
        System.out.println("Population size ==> " + population.length);
        System.out.println(Arrays.toString(population));
//        Selection selection = new CrowdingOutSelection(0.7);
//        System.out.println(Arrays.toString(selection.select(new MyFitnessFunction(), chromosomes)));
//        System.out.println("Population:");
//        System.out.println(Arrays.toString(chromosomes));
//        Selection selection = new SelectiveSelection();
//        System.out.println("Survivors:");
//        System.out.println(Arrays.toString(selection.select(new MyFitnessFunction(), chromosomes)));
//        Breeder breeder = new TwoPointBreeder();
//        Mutagen mutagen = new RandomMutagen(0.91);
//        System.out.println("F: " + ch1);
//        System.out.println("M: " + ch2);
//        Chromosome child = breeder.breed(ch1, ch2);
//        System.out.println("Child: " + child);
//        Chromosome mutant = mutagen.mutate(child);
//        System.out.println("Mutant: " + mutant);
    }

    private static Chromosome getRandomChromosome(int tupleLength, int limit) {
        Random random = new Random();
        int[] values = new int[tupleLength];
        for(int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(limit);
        }
        return new MyChromosome(values);
    }

}


