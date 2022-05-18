package com.mercadolibre.demo.utilitis;

public class CheckMatrixUtils {

    public static boolean checkMatrix(String[] dna) throws Exception {

        int dnaSize = dna.length;
        String validStrings = "[ACGT]+";

        for (String dnaSequence : dna) {
            if (dnaSequence.length() != dnaSize) {
                System.out.println("matrix Invalid");
                throw new Exception("matrix Invalid");
            }

            if (!dnaSequence.matches(validStrings)) {
                System.out.println("Seguence Invalid");
                throw new Exception("Seguence Invalid refe: (A,T,C,G)");
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
