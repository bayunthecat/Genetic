package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.Breeder;
import com.nure.genetic.abstraction.Chromosome;

import java.util.Random;

import static com.nure.genetic.utils.NumericUtils.*;

public class TwoPointBreeder implements Breeder {

    private Random random = new Random();

    @Override
    public Chromosome[] breed(Chromosome chr1, Chromosome chr2) {
        boolean[] father = toBooleanArray(chr1.getValues());
        boolean[] mother = toBooleanArray(chr2.getValues());
        checkArgs(father, mother);
        int jointA = getJoint(father.length), jointB = getJoint(father.length);
        for(int i = Math.min(jointA, jointB); i < Math.max(jointA, jointB); i++) {
            boolean temp = father[i];
            father[i] = mother[i];
            mother[i] = temp;
        }
        return new Chromosome[] {new MyChromosome(toFloatArray(father)), new MyChromosome(toFloatArray(mother))};
    }

    private int getJoint(int limit) {
        return random.nextInt(limit);
    }

    private void checkArgs(boolean[] chr1, boolean[] chr2) {
        if(chr1.length != chr2.length) {
            throw new IllegalArgumentException("Chromosomes has different length");
        }
        if(chr1.length == 0) {
            throw new IllegalArgumentException("Chromosomes is empty");
        }
    }


}
