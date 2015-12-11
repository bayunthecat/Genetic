package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.Breeder;
import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.utils.NumericUtils;

import java.util.Random;

public class TwoPointBreeder implements Breeder {

    private Random random = new Random();

    @Override
    public Chromosome[] breed(Chromosome chr1, Chromosome chr2) {
        boolean[] father = toBoolean(chr1.getValues());
        boolean[] mother = toBoolean(chr2.getValues());
        checkArgs(father, mother);
        int jointA = getJoint(father.length), jointB = getJoint(father.length);
        for(int i = Math.min(jointA, jointB); i < Math.max(jointA, jointB); i++) {
            boolean temp = father[i];
            father[i] = mother[i];
            mother[i] = temp;
        }
        return new Chromosome[] {};
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

    private float[] toFloat(float[] array) {
        float[] result = new float[array.length];
        return null;
    }

    private boolean[] toBoolean(float[] array) {
        boolean[] result = new boolean[array.length * 32];
        int resultIndex = 0;
        for (int i = 0; i < array.length; i++) {
            boolean[] value = NumericUtils.toBoolean(array[i]);
            System.arraycopy(value, 0, result, resultIndex, value.length);
            resultIndex += value.length;
        }
        return result;
    }
}
