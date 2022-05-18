package com.mercadolibre.demo.services;

import com.mercadolibre.demo.entities.Stats;
import com.mercadolibre.demo.repositories.StatsRepository;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MutantServiceTest {

    @InjectMocks
    MutantService mutantService = new MutantService();

    @Mock
    private StatsRepository statsRepository;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkMutantDnaFiveByFiveMatrixVertical() throws Exception {
        String[] dna = { "AATAA", "CATGC", "TATCG", "CATAC", "CCGTC" };
        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    public void mutantDnaSixBySixMatrixVertical() throws Exception {
        String[] dna = { "GACTAC", "GACTAC", "GTCTAC", "ATGCGC", "GTTCAT", "ATGCGA" };
        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    public void humanDnaFiveByFiveMatrix() throws Exception {
        String[] dna = { "ATGCG", "CATCA", "TAGTT", "GTCTG", "GTACC" };
        assertFalse(mutantService.isMutant(dna));
    }

    @Test
    public void humanDnaSixBySixMatrix() throws Exception {
        String[] dna = { "ATGCGA", "CATCTA", "TAGTAT", "GTCTGG", "GTCACC", "ATTGCA" };
        assertFalse(mutantService.isMutant(dna));
    }
}

