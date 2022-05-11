package com.mercadolibre.demo.services;

import com.mercadolibre.demo.entities.Stats;
import com.mercadolibre.demo.repositories.StatsRepository;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MutantServiceTest {

    @InjectMocks
    MutantService mutantService = new MutantService();

    @Mock
    private StatsRepository statsRepository;

    @Before
    public void init(){
        when(statsRepository.save(Mockito.any())).thenReturn(0);
    }

    @Test
    public void mutantDnaFourByFourMatrixHorizontal() throws Exception {
        String[] dna = { "AAAA", "CCCC", "GACT", "GACT" };
        Stats stats = new Stats(1,1,1);
        when(statsRepository.save(stats)).thenReturn(stats);
        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    public void mutantDnaSixBySixMatrixVertical() throws Exception {
        String[] dna = { "GACTAC", "GACTAC", "GTCTAC", "ATGCGC", "GTTCAT", "ATGCGA" };
        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    public void mutantDnaFourByFourMatrixOblique() throws Exception {
        String[] dna = { "GACC", "AGCC", "GCGT", "CTCG" };
        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    public void mutantDnaFourByFourMatrixMix() throws Exception {
        String[] dna = { "ATGA", "CGAC", "TAAT", "AAAA" };
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

