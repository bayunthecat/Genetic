package com.nure.genetic.utils;

public class NumericUtils {

    public static double checkProbability(double value, double defaultValue) {
        return value <= 1.0 && value >= 0.0 ? value : defaultValue;
    }

    public static boolean[] toBoolean(float value) {
        int iee = Float.floatToIntBits(value);
        String binary = Integer.toBinaryString(iee);
        boolean[] result = new boolean[32];
        for(int i = binary.length() - 1; i >= 0; i--) {
            result[i] = binary.charAt(i) != '0';
        }
        return result;
    }

    public static boolean[] toBooleanArray(float[] array) {
        boolean[] result = new boolean[array.length * 32];
        int resultIndex = 0;
        for (float anArray : array) {
            boolean[] value = toBoolean(anArray);
            System.arraycopy(value, 0, result, resultIndex, value.length);
            resultIndex += value.length;
        }
        return result;
    }

    public static float toFloat(boolean[] value) {
        StringBuilder binary = new StringBuilder();
        for(int i = 0; i < value.length; i++) {
            binary.append(value[i] ? "1" : "0");
        }
        String binString = binary.toString();
        StringBuilder onesComplementBuilder = new StringBuilder();
        for(char bit : binString.toCharArray()) {
            onesComplementBuilder.append((bit == '0') ? 1 : 0);
        }
        String onesComplement = onesComplementBuilder.toString();
        int converted = Integer.valueOf(onesComplement, 2);
        int v = -(converted + 1);
        return Float.intBitsToFloat(v) * 1000 / 1000;
    }

    public static float[] toFloatArray(boolean[] array) {
        int tupleLength = array.length / 32;
        int counter = 0;
        float[] result = new float[tupleLength];
        for (int i = 0; i < tupleLength; i++) {
            boolean[] number = new boolean[32];
            System.arraycopy(array, counter, number, 0, number.length);
            result[i] = toFloat(number);
            counter += 32;
        }
        return result;
    }

    private NumericUtils() {}
}
