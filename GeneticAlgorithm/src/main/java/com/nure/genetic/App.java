package com.nure.genetic;

import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.abstraction.GeneticTask;
import com.nure.genetic.implementation.*;
import com.nure.genetic.utils.NumericUtils;

import java.util.Arrays;
import java.util.Random;

public class App {

    public static void main(String[] args) {
//        Chromosome ch1 = getRandomChromosome(1);
//        Chromosome ch2 = getRandomChromosome(1);
//        Chromosome ch3 = getRandomChromosome(1);
//        Chromosome ch4 = getRandomChromosome(1);
//        Chromosome ch5 = getRandomChromosome(1);
//        Chromosome[] chromosomes = {ch1, ch2, ch3, ch4, ch5};
//        GeneticTask task = new MyGeneticTask(0.001);
//        task.solve(new MyFitnessFunction(), new BreedingContainer(), new SelectiveSelection(), new CrowdingOutSelection(0.7), new RandomMutagen(0.26), chromosomes);
        boolean[] array = NumericUtils.toBoolean(-0.23f);
        System.out.println("My ==> " + Arrays.toString(array));
        System.out.println("Reverse ==> " + NumericUtils.toFloat(array));
    }

    private static Chromosome getRandomChromosome(int tupleLength) {
        Random random = new Random();
        int[] values = new int[tupleLength];
        for(int i = 0; i < values.length; i++) {
            values[i] = random.nextInt();
        }
        return null;
    }

}


