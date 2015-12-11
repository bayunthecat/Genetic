package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.abstraction.FitnessFunction;
import com.nure.genetic.abstraction.Selection;
import com.nure.genetic.utils.NumericUtils;

import java.util.ArrayList;
import java.util.List;

public class SelectiveSelection implements Selection {

    @Override
    public Chromosome[] select(FitnessFunction function, Chromosome... chromosomes) {
        checkValidArgs(chromosomes);
        return null;
    }

    private void checkValidArgs(Chromosome[] chromosomes) {
        if (chromosomes.length == 0) {
            throw new IllegalArgumentException("The chromosomes array length is 0 at some point.");
        }
    }
}
