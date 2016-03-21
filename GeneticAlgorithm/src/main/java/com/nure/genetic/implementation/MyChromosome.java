package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.utils.NumericUtils;

import java.util.Arrays;

public class MyChromosome implements Chromosome {

    private float[] values;

    public MyChromosome(float[] values) {
        this.values = values;
    }

    @Override
    public void setValues(float[] values) {
        this.values = values;
    }

    @Override
    public float[] getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "MyChromosome{" +
                "values=\n" + Arrays.toString(values) +
                "\nbinary=\n" + toString(NumericUtils.toBooleanArray(values)) +
                '}';
    }

    private String toString(boolean[] values) {
        StringBuilder builder = new StringBuilder();
        for (boolean b : values) {
            builder.append(b ? "1" : "0");
        }
        return builder.toString();
    }
}
