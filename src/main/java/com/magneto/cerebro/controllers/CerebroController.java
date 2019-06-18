package com.magneto.cerebro.controllers;

import com.magneto.cerebro.application.EntityToDTO;
import com.magneto.cerebro.controllers.models.DnaRequest;
import com.magneto.cerebro.controllers.models.DnaStatsResponse;
import com.magneto.cerebro.domain.Dna;
import com.magneto.cerebro.service.IDnaService;
import com.magneto.cerebro.application.MutantFinder;
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
     * @return HttpStatus.OK si el adn es de mutante o HttpStatus.FORBIDDEN si es un humano.
     * */
    @RequestMapping(method = POST)
    public ResponseEntity mutant(@RequestBody DnaRequest dnaRequest) throws InterruptedException, ExecutionException {
        String[] dna = dnaRequest.getDna();

        boolean isMutant =
                CompletableFuture
                        .completedFuture(MutantFinder.isMutant(dna))
                        .thenApplyAsync(bIsMutant -> {

                            Dna dnaEntity = new Dna();
                            dnaEntity.setDna(Arrays.toString(dna));
                            dnaEntity.setIsMutant(bIsMutant);

                            dnaService.addDna(dnaEntity);

                            return bIsMutant;

                        }).get();

        if (isMutant)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    /*
     * Devuelve las estadísticas de mutantes encontrados.
     * @return un objeto DnaStatsResponse con la cantidad de mutantes y humanos encontrados
     * y el ratio entre ambos.
     * */
    @RequestMapping(method = GET)
    public ResponseEntity<DnaStatsResponse> stats() throws InterruptedException, ExecutionException {
        DnaStatsResponse stats =
                CompletableFuture
                        .completedFuture(dnaService.findAll())
                        .thenApplyAsync(EntityToDTO::dnaToDnaStatsResponse)
                        .get();

        return ResponseEntity.ok(stats);
    }
}
