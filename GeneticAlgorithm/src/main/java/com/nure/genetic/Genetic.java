package com.nure.genetic;

import java.util.Random;

public class Genetic {

    public static final String DOT = ".";

    private boolean[][] populationArray;

    private int speciesCount;

    private int constraint;

    private int fromMultiplier;

    private Random random = new Random();

    public Genetic(int speciesCount, int constraint) {
        this.speciesCount = speciesCount;
        this.constraint = constraint;
        populationArray = new boolean[speciesCount][speciesCount * 32];
    }

    public void solve() {

    }

    public void generateRandomBooleanArrayAccordingToConstraints() {
        for (int i = 0; i < populationArray.length; i++) {
            int value = getInt();
            populationArray[i] = intToBooleanArray(value);
        }
    }

    private int convertToInt(double value) {
        int result = 0;
        int indexOfDot;
        int floatMultiplier = 10;
        String doubleString = String.valueOf(value);
        if ((indexOfDot = doubleString.indexOf(DOT)) != -1) {
            result = (int) (Math.pow(floatMultiplier, doubleString.length() - (indexOfDot + 1)) * value);
        }
        return result;
    }

    public int convertBoolean(boolean[] value) {
        int result;
        StringBuilder builder = new StringBuilder();
        for (boolean aValue : value) {
            builder.append(aValue ? 1 : 0);
        }
        result = Integer.parseInt(builder.toString(), 2);
        return result;
    }

    public boolean[] intToBooleanArray(int value) {
        String binaryValue = Integer.toBinaryString(value);
        boolean[] result = new boolean[32];
        int resultCount = result.length - 1;
        for (int i = binaryValue.length() - 1; i >= 0; i--) {
            result[resultCount--] = canonicalBoolToBoolean(Integer.parseInt(String.valueOf(binaryValue.charAt(i))));
        }
        return result;
    }

    private int getInt() {
        return random.nextInt(constraint * 2) - constraint;
    }

    private boolean canonicalBoolToBoolean(int value) {
        return value != 0;
    }

    private double fitnessFunction(double... xs) {
        double result = 0;
        for (double d : xs) {
            result += d;
        }
        return result;
    }
}
