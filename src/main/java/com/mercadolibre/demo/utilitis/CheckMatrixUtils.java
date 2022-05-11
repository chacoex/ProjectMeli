package com.mercadolibre.demo.utilitis;

public class CheckMatrixUtils {

    public static boolean checkMatrix(String[] dna){

        int dnaSize = dna.length;
        String validStrings = "[ACGT]+";

        for (String dnaSequence : dna) {
            if (dnaSequence.length() != dnaSize) {

            }

            if (!dnaSequence.matches(validStrings)) {

            }

        }

        return true;
    }

    public static String convertToString(String[] strArr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str).append(delimiter);
        return sb.substring(0, sb.length() - 1);
    }
}
