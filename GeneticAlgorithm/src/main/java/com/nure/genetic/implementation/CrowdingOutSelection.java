package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.abstraction.FitnessFunction;
import com.nure.genetic.abstraction.Selection;
import com.nure.genetic.utils.NumericUtils;

import java.util.ArrayList;
import java.util.List;


public class CrowdingOutSelection implements Selection {

    private double fitnessRatio;

    public static final double DEFAULT_FITNESS_RATIO = 0.6;

    public CrowdingOutSelection(double fitnessRatio) {
        this.fitnessRatio = NumericUtils.checkProbability(fitnessRatio, DEFAULT_FITNESS_RATIO);
    }

    @Override
    public Chromosome[] select(FitnessFunction function, Chromosome... chromosomes) {
        double[] fitnessRatios = getFitnessRatios(function, chromosomes);
        //noinspection ToArrayCallWithZeroLengthArrayArgument
        return choosePopulation(fitnessRatios, chromosomes).toArray(new Chromosome[0]);
    }

    private List<Chromosome> choosePopulation(double[] fitnessRatios, Chromosome[] chromosomes) {
        List<Chromosome> futurePopulation = new ArrayList<>();
        double best = getMaxAdaptationRatio(fitnessRatios), worst = getMinAdaptationRatio(fitnessRatios);
        for (int i = 0; i < chromosomes.length; i++) {
            if(countUse(fitnessRatios[i], best, worst) >= fitnessRatio) {
                futurePopulation.add(chromosomes[i]);
            }
        }
        return futurePopulation;
    }

    private double countUse(double current, double best, double worst) {
        return (current - worst) / (best - worst);
    }

    private double[] getFitnessRatios(FitnessFunction function, Chromosome[] chromosomes) {
        double[] fitnessRatios = new double[chromosomes.length];
        for (int i = 0; i < chromosomes.length; i++) {
            MyChromosome myChromosome = (MyChromosome)chromosomes[i];
            fitnessRatios[i] = 0;
        }
        return fitnessRatios;
    }

    private double getMaxAdaptationRatio(double[] array) {
        double max = Double.MIN_VALUE;
        for(double d : array) {
            if(d > max) {
                max = d;
            }
        }
        return max;
    }

    private double getMinAdaptationRatio(double[] array) {
        double min = Double.MAX_VALUE;
        for(double d : array) {
            if(d < min) {
                min = d;
            }
        }
        return min;
    }

}
