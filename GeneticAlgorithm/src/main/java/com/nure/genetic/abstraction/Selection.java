package com.nure.genetic.abstraction;

public interface Selection {
    Chromosome[] select(FitnessFunction function, Chromosome... chromosomes);
}
