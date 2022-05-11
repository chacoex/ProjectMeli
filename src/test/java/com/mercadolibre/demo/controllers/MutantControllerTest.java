package com.mercadolibre.demo.controllers;


import static org.assertj.core.api.Assertions.assertThat;



import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mercadolibre.demo.services.MutantService;


@SpringBootTest
public class MutantControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MutantService mutantService;


    @InjectMocks
    private MutantController mutantController;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mutantController).build();

    }

    @Test
    public void controllerInitializedCorrectly() {
        assertThat(mutantController).isNotNull();

    }

    @Test
    public void postMutantStatusForbiddenIsHuman() throws Exception {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/ismutant/")
                .content(String.valueOf(dna));
        assertThat(mutantController).isNotNull();

    }

}
