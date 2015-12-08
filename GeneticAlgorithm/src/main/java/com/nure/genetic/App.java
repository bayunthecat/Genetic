package com.nure.genetic;

import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.implementation.MyChromosome;

public class App {

    public static void main(String[] args) {
        Chromosome ch = new MyChromosome(new int[] {256, 128, 64, 16, 8});
        System.out.println(ch);
    }

}


