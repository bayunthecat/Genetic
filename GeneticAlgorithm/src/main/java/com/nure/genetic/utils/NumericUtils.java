package com.nure.genetic.utils;

public class NumericUtils {

    public static boolean[] transformInt(int value, int platform) {
        String binaryValue = Integer.toBinaryString(value);
        boolean[] result = new boolean[platform];
        int resultCount = result.length - 1;
        for (int i = binaryValue.length() - 1; i >= 0; i--) {
            result[resultCount--] = binaryValue.charAt(i) != '0';
        }
        return result;
    }

    public static double checkProbability(double value, double defaultValue) {
        return value <= 1.0 && value >= 0.0 ? value : defaultValue;
    }
    public static double[] convertToDoubleArray(int[] values) {
        double[] doubleValues = new double[values.length];
        for(int i = 0; i < values.length; i++) {
            doubleValues[i] = values[i];
        }
        return doubleValues;
    }


    public static int transformBoolean(boolean[] value, int platform) {
        StringBuilder builder = new StringBuilder();
        for(boolean val : value) {
            builder.append(val ? "1" : "0");
        }
        return Integer.parseInt(builder.toString(), 2);
    }

    private NumericUtils() {}
}
