package com.nure.genetic.implementation;

import com.nure.genetic.abstraction.Chromosome;
import com.nure.genetic.abstraction.DecimalView;
import com.nure.genetic.utils.NumericUtils;

import java.util.Arrays;

public class MyChromosome implements Chromosome, DecimalView{

    private static final int PLATFORM = 32;
    public static final String SEPARATOR = " ";

    private boolean[] binaryView;

    private int[] decimalView;

    private int tupleLength;

    public MyChromosome(int[] values) {
        decimalView = values;
        this.tupleLength = values.length;
        binaryView = new boolean[PLATFORM * tupleLength];
        fillBooleanArray();
    }

    public MyChromosome(boolean[] values) {
        binaryView = values;
        tupleLength = values.length / PLATFORM;
        fillDecimalArray();
    }

    @Override
    public boolean[] getBinaryValues() {
        return binaryView;
    }

    @Override
    public int[] getDecimalValues() {
        return decimalView;
    }

    //Wrong
    private void fillBooleanArray() {
        int overallLength = 0;
        for(int value : decimalView) {
            boolean[] src = NumericUtils.transformInt(value, PLATFORM);
            System.arraycopy(src, 0, binaryView, overallLength, src.length);
            overallLength += src.length;
        }
    }

    private void fillDecimalArray() {
        int binaryViewPointer = 0;
        for(int i = 0; i < tupleLength; i++) {
            boolean[] value = new boolean[PLATFORM];
            System.arraycopy(binaryView, binaryViewPointer, value, 0, value.length);
            binaryViewPointer += value.length;
        }
    }

    @Override
    public String toString() {
        return "MyChromosome{\n" +
                "binaryView=[" + toStringBooleanArray(binaryView) +
                "],\ndecimalView=[" + Arrays.toString(decimalView) +
                "]}";
    }

    private String toStringBooleanArray(boolean[] array) {
        StringBuilder builder = new StringBuilder();
        int separatorCounter = 0;
        for(boolean value : array) {
            builder.append(value ? "1" : "0");
            if(separatorCounter == PLATFORM) {
                builder.append(SEPARATOR);
                separatorCounter = 0;
            }
            separatorCounter++;
        }
        return builder.toString();
    }
}