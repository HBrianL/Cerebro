package com.magneto.cerebro.controllers;

import com.magneto.cerebro.controllers.models.DnaRequest;
import com.magneto.cerebro.utils.HorizontalSequenceFinder;
import com.magneto.cerebro.utils.ObliqueLeftSequenceFinder;
import com.magneto.cerebro.utils.ObliqueRightSequenceFinder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class CerebroController {

    @RequestMapping(method = POST)
    public HttpStatus mutant(@RequestBody DnaRequest dna) {
        boolean result = new ObliqueRightSequenceFinder(dna.getDna(), 4).Find();

        if (result) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.FORBIDDEN;
        }

    }
}
