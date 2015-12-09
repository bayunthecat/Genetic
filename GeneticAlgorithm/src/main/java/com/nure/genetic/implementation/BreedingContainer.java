package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.Breeder;
import com.nure.genetic.abstraction.Chromosome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreedingContainer {

    private Breeder breeder;

    public BreedingContainer() {
        breeder = new TwoPointBreeder();
    }

    public Chromosome[] getPopulation(Chromosome[] chromosomes) {
        List<Chromosome> list = new ArrayList<>();
        for(int i = 0; i < chromosomes.length; i++) {
            for(int j = i; j < chromosomes.length; j++) {
                list.addAll(Arrays.asList(breeder.breed(chromosomes[i], chromosomes[j])));
            }
        }
        return list.toArray(new Chromosome[0]);
    }


}
