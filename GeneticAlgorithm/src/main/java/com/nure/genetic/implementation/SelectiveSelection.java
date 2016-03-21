package com.nure.genetic.implementation;

        import com.nure.genetic.abstraction.Chromosome;
        import com.nure.genetic.abstraction.FitnessFunction;
        import com.nure.genetic.abstraction.Selection;

        import java.util.ArrayList;
        import java.util.List;

public class SelectiveSelection implements Selection {

    @Override
    public Chromosome[] select(FitnessFunction function, Chromosome... chromosomes) {
        checkValidArgs(chromosomes);
        float[] fitnessFunction = getFitnessFunction(function, chromosomes);
        float average = getAverage(fitnessFunction);
        List<Chromosome> futureParents = new ArrayList<>();
        for(int i = 0; i < fitnessFunction.length; i++) {
            if(fitnessFunction[i] > average) {
                futureParents.add(chromosomes[i]);
            }
        }
        return futureParents.toArray(new Chromosome[1]);
    }

    private float[] getFitnessFunction(FitnessFunction f ,Chromosome... chromosomes) {
        float[] fitness = new float[chromosomes.length];
        for (int i = 0; i < fitness.length; i++) {
            fitness[i] = f.getValue(chromosomes[i].getValues());
        }
        return fitness;
    }

    private float getAverage(float[] fitness) {
        float average = 0;
        for (double d : fitness) {
            average += d;
        }
        return average / fitness.length;
    }

    private void checkValidArgs(Chromosome[] chromosomes) {
        if (chromosomes.length == 0) {
            throw new IllegalArgumentException("The chromosomes array length is 0 at some point.");
        }
    }
}
