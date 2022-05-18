package com.mercadolibre.demo.utilitis;

import org.junit.Test;

public class CheckMatrixUtilsTest {

    @Test(expected = Exception.class)
    public void checkDnaInvalidMatrixSize() throws Exception {
        String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCAA" };
        CheckMatrixUtils.checkMatrix(dna);
    }

    @Test(expected = Exception.class)
    public void checkDnaInvalidSequence() throws Exception {
        String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "XXXXXX" };
        CheckMatrixUtils.checkMatrix(dna);
    }

}
