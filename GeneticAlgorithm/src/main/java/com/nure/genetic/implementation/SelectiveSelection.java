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
        double averageAdaptationRatio = getAverageAdaptationRatio(chromosomes, function);
        return formFutureParentsArray(chromosomes, function, averageAdaptationRatio);
    }

    private void checkValidArgs(Chromosome[] chromosomes) {
        if(chromosomes.length == 0) {
            throw new IllegalArgumentException("The chromosomes array length is 0 at some point.");
        }
    }

    private double getAverageAdaptationRatio(Chromosome[] chromosomes, FitnessFunction function) {
        double averageAdaptationRatio = 0;
        for(Chromosome ch : chromosomes) {
            MyChromosome chromosome = (MyChromosome)ch;
            averageAdaptationRatio += function.getValue(NumericUtils.convertToDoubleArray(chromosome.getDecimalValues()));
        }
        return averageAdaptationRatio / chromosomes.length;
    }

    private Chromosome[] formFutureParentsArray(Chromosome[] chromosomes, FitnessFunction function, double averageAdaptationRatio) {
        List<Chromosome> futureParents = new ArrayList<>();
        for (Chromosome ch : chromosomes) {
            MyChromosome myChromosome = (MyChromosome)ch;
            if(function.getValue(NumericUtils.convertToDoubleArray(myChromosome.getDecimalValues())) >= averageAdaptationRatio) {
                futureParents.add(ch);
            }
        }
        //noinspection ToArrayCallWithZeroLengthArrayArgument
        return futureParents.toArray(new Chromosome[0]);
    }
}
