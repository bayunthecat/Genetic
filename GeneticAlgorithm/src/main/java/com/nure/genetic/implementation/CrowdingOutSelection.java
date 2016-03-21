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
        float[] fitnessRatios = getFitnessRatios(function, chromosomes);
        return choosePopulation(fitnessRatios, chromosomes).toArray(new Chromosome[1]);
    }

    private List<Chromosome> choosePopulation(float[] fitnessRatios, Chromosome[] chromosomes) {
        List<Chromosome> futurePopulation = new ArrayList<>();
        float best = getMaxAdaptationRatio(fitnessRatios), worst = getMinAdaptationRatio(fitnessRatios);
        for (int i = 0; i < chromosomes.length; i++) {
            if(countUse(fitnessRatios[i], best, worst) >= fitnessRatio) {
                futurePopulation.add(chromosomes[i]);
            }
        }
        return futurePopulation;
    }

    private double countUse(float current, float best, float worst) {
        return (current - worst) / (best - worst);
    }

    private float[] getFitnessRatios(FitnessFunction function, Chromosome[] chromosomes) {
        float[] fitnessRatios = new float[chromosomes.length];
        for (int i = 0; i < chromosomes.length; i++) {
            fitnessRatios[i] = function.getValue(chromosomes[i].getValues());
        }
        return fitnessRatios;
    }

    private float getMaxAdaptationRatio(float[] array) {
        float max = Float.MIN_VALUE;
        for(float f : array) {
            if(f > max) {
                max = f;
            }
        }
        return max;
    }

    private float getMinAdaptationRatio(float[] array) {
        float min = Float.MAX_VALUE;
        for(float f : array) {
            if(f < min) {
                min = f;
            }
        }
        return min;
    }

}
