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

    public static int transformBoolean(boolean[] value, int platform) {
        StringBuilder builder = new StringBuilder();
        for(boolean val : value) {
            builder.append(val ? "1" : "0");
        }
        return Integer.parseInt(builder.toString(), 2);
    }

    private NumericUtils() {}
}
