package com.magneto.cerebro;

import com.magneto.cerebro.controllers.CerebroController;
import com.magneto.cerebro.domain.Dna;
import com.magneto.cerebro.service.IDnaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CerebroController.class)
public class CerebroApplicationTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IDnaService service;

    @Test
    public void givenDna_whenIsMutant_thenReturnStatusOk() throws Exception {
        String dna = "{ \"dna\": [\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTT\"] }";

        doNothing().when(service).addDna(any(Dna.class));

        mvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dna))
                .andExpect(status().isOk());

        verify(service, times(1)).addDna(any(Dna.class));
    }

    @Test
    public void givenDna_whenNotIsMutant_thenReturnsStatusForbidden() throws Exception {
        String dna = "{ \"dna\": [\"ATGCGA\",\"CAGTGC\",\"TTATTT\",\"AGACGG\",\"GCGTCA\",\"TCATCG\"] }";

        doNothing().when(service).addDna(any(Dna.class));

        mvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dna))
                .andExpect(status().isForbidden());

        verify(service, times(1)).addDna(any(Dna.class));
    }

}
