package com.magneto.cerebro;

import com.magneto.cerebro.controllers.CerebroController;
import com.magneto.cerebro.domain.Dna;
import com.magneto.cerebro.repository.DnaRepository;
import com.magneto.cerebro.service.DnaService;
import com.magneto.cerebro.service.IDnaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Iterator;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CerebroController.class)
public class CerebroApplicationTests {

    @TestConfiguration
    static class CerebroApplicationTestsConfiguration {

        @Bean
        public IDnaService dnaService() {
            return new DnaService();
        }
    }

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DnaRepository repository;

    @Test
    public void givenDna_whenIsMutant_thenReturnStatusOk() throws Exception {
        String dna = "{ \"dna\": [\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTT\"] }";

        mvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dna))
                .andExpect(status().isOk());
    }

    @Test
    public void givenDna_whenNotIsMutant_thenReturnsStatusForbidden() throws Exception {
        String dna = "{ \"dna\": [\"ATGCGA\",\"CAGTGC\",\"TTATTT\",\"AGACGG\",\"GCGTCA\",\"TCATCG\"] }";

        mvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dna))
                .andExpect(status().isForbidden());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void givenTwoDnas_thenReturnsStatsIsMutant() throws Exception {
        // givens
        Dna dnaMutant = new Dna();
        dnaMutant.setIsMutant(true);

        Dna dnaHuman = new Dna();
        dnaHuman.setIsMutant(false);

        Iterable mockIterable = mock(Iterable.class);
        Iterator mockIterator = mock(Iterator.class);

        when(mockIterator.hasNext()).thenReturn(true, true, false);
        when(mockIterator.next()).thenReturn(dnaMutant, dnaHuman);

        when(repository.findAll()).thenReturn(mockIterable);
        when(mockIterable.iterator()).thenReturn(mockIterator);

        mvc.perform(get("/stats"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"count_mutant_dna\":1,\"count_human_dna\":1,\"ratio\":0.0}"));

        verify(repository, times(1)).findAll();
    }

}
