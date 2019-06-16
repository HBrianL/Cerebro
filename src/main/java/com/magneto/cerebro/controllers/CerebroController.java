package com.magneto.cerebro.controllers;

import com.magneto.cerebro.controllers.models.DnaRequest;
import com.magneto.cerebro.domain.IDnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class CerebroController {
    @Autowired
    private IDnaService dnaService;

    @RequestMapping(method = POST)
    public HttpStatus mutant(@RequestBody DnaRequest dna) {
        if (dnaService.isMutant(dna.getDna()))
            return HttpStatus.OK;
        else
            return HttpStatus.FORBIDDEN;
    }
}
