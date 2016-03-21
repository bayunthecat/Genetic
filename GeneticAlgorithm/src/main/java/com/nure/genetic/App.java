package com.nure.genetic;

import com.nure.genetic.abstraction.Breeder;
import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.abstraction.GeneticTask;
import com.nure.genetic.abstraction.Mutagen;
import com.nure.genetic.implementation.*;
import com.nure.genetic.utils.NumericUtils;

import java.util.Arrays;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        Chromosome ch1 = getRandomChromosome(1);
        Chromosome ch2 = getRandomChromosome(1);
        Chromosome ch3 = getRandomChromosome(1);
        Chromosome ch4 = getRandomChromosome(1);
        Chromosome ch5 = getRandomChromosome(1);
        Chromosome[] chromosomes = {ch1, ch2, ch3, ch4, ch5};
        GeneticTask task = new MyGeneticTask(0.0000000001);
        Chromosome best = new MyChromosome(new float[]{4.98f, 5.00f, 5.12f, 4.78f, 4.99f});
        System.out.println("And the winner is ==> " + best);
    }

    private static Chromosome getRandomChromosome(int tupleLength) {
        float[] values = new float[tupleLength];
        for(int i = 0; i < values.length; i++) {
            values[i] = getRandomFloat(-5.12f, +5.12f);
        }
        return new MyChromosome(values);
    }

    static float getRandomFloat(float min ,float max) {
        return (new Random().nextFloat() * (max - min)) + min;
    }

}


