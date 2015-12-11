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

    public static boolean[] toBoolean(float value) {
        int iee = Float.floatToIntBits(value);
        String binary = Integer.toBinaryString(iee);
        boolean[] result = new boolean[32];
        for(int i = binary.length() - 1; i >= 0; i--) {
            result[i] = binary.charAt(i) != '0';
        }
        return result;
    }

    public static boolean[] floatArrayToBoolean(float[] array) {
        return null;
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
        System.out.println(onesComplement);
        int converted = Integer.valueOf(onesComplement, 2);
        int v = -(converted + 1);
        return Float.intBitsToFloat(v);
    }

    private NumericUtils() {}
}
