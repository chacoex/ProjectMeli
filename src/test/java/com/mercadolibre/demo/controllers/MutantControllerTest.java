package com.mercadolibre.demo.controllers;


import static org.assertj.core.api.Assertions.assertThat;


import com.mercadolibre.demo.entities.Stats;
import com.mercadolibre.demo.repositories.StatsRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import com.mercadolibre.demo.services.MutantService;


@SpringBootTest
@AutoConfigureMockMvc
public class MutantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MockMvc mockMvcc;

    @InjectMocks
    private MutantService mutantService;

    @Mock
    private StatsRepository statsRepository;


    @InjectMocks
    private MutantController mutantController;

    @Before
    public void init(){
        Stats stats = new Stats(2, 0.0, 1.0);
        statsRepository.deleteAll();
        statsRepository.save(stats);

    }

    @Test
    public void controllerInitializedCorrectly() {
        assertThat(mutantController).isNotNull();

    }

    @Test
    public void postMutantStatusOkIsMutant() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/ismutant/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}");
        this.mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    public void postMutantStatusForbiddenIsHuman() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/ismutant/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGACGG\",\"GCGTCA\",\"TCACTG\"]}");
        this.mockMvc.perform(builder).andExpect(status().isForbidden());
    }

    @Test
    public void getStatsStatusOK() throws Exception {

        Stats stats = new Stats(2, 0.0, 1.0);

        when(statsRepository.countStats())
                .thenReturn(stats);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/stats");
        assertThat(mutantController).isNotNull();

    }

}
