package com.nure.genetic;

import com.nure.genetic.abstraction.Breeder;
import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.implementation.MyChromosome;
import com.nure.genetic.implementation.TwoPointBreeder;

public class App {

    public static void main(String[] args) {
        Chromosome ch1 = new MyChromosome(new int[]{1, 2, 12, 163, 512});
        Chromosome ch2 = new MyChromosome(new int[]{30, 26, 84, 69, 506});
        Breeder breeder = new TwoPointBreeder();
        breeder.breed();
        System.out.println(ch);
    }

}


