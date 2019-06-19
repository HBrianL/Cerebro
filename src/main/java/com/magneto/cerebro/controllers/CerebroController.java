package com.magneto.cerebro.controllers;

import com.magneto.cerebro.application.EntityToDTO;
import com.magneto.cerebro.controllers.models.DnaRequest;
import com.magneto.cerebro.controllers.models.DnaStatsResponse;
import com.magneto.cerebro.service.IDnaService;
import com.magneto.cerebro.application.MutantFinder;
import com.magneto.cerebro.utils.sequenceFinder.builder.SequenceFinderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class CerebroController {
    @Autowired
    private IDnaService dnaService;

    /*
     * Detecta si un humano es mutante según la secuencia de ADN recibida.
     * @param dnaRequest objeto con la secuencia de adn { adn: String[] }
     * @return HttpStatus.OK si el adn es de mutante, HttpStatus.FORBIDDEN si es un humano
     * o HttpStatus.BAD_REQUEST si el adn está mal formado o tiene bases nitrogenadas incorrectas.
     * */
    @RequestMapping(method = POST)
    public ResponseEntity mutant(@RequestBody DnaRequest dnaRequest) throws InterruptedException, ExecutionException {
        String[] dna = dnaRequest.getDna();

        String validNitroBase = "ATCG";
        MutantFinder mutantFinder = new MutantFinder(dna, new SequenceFinderBuilder());

        if (mutantFinder.hasValidDnaLength() && mutantFinder.hasValidNitroBase(validNitroBase)) {
            boolean isMutant =
                    CompletableFuture
                            .completedFuture(mutantFinder.isMutant(4))
                            .thenApplyAsync(bIsMutant -> {
                                dnaService.addDna(dnaService.createDna(Arrays.toString(dna), bIsMutant));
                                return bIsMutant;
                            }).get();
            if (isMutant)
                return new ResponseEntity(HttpStatus.OK);
            else
                return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    /*
     * Devuelve las estadísticas de mutantes encontrados.
     * @return un objeto DnaStatsResponse con la cantidad de mutantes y humanos encontrados
     * y el ratio entre ambos.
     * */
    @RequestMapping(method = GET)
    public ResponseEntity<DnaStatsResponse> stats() throws InterruptedException, ExecutionException {
        EntityToDTO entityToDTO = new EntityToDTO();
        DnaStatsResponse stats =
                CompletableFuture
                        .completedFuture(dnaService.findAll())
                        .thenApplyAsync(entityToDTO::dnaToDnaStatsResponse)
                        .get();

        return ResponseEntity.ok(stats);
    }
}
