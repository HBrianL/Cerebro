package com.magneto.cerebro.controllers;

import com.magneto.cerebro.controllers.models.DnaRequest;
import com.magneto.cerebro.controllers.models.DnaStatsResponse;
import com.magneto.cerebro.domain.Dna;
import com.magneto.cerebro.service.IDnaService;
import com.magneto.cerebro.utils.MutantFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

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
    public ResponseEntity mutant(@RequestBody DnaRequest dnaRequest) {
        String[] dna = dnaRequest.getDna();
        boolean isMutant = MutantFinder.isMutant(dna);

        Dna dnaEntity = new Dna();
        dnaEntity.setDna(Arrays.toString(dna));
        dnaEntity.setIsMutant(isMutant);

        dnaService.addDna(dnaEntity);

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
    public ResponseEntity<DnaStatsResponse> stats() {
        DnaStatsResponse stats = dnaService.getStats();

        return ResponseEntity.ok(stats);
    }
}
