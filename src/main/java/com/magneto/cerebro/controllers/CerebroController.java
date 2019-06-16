package com.magneto.cerebro.controllers;

import com.magneto.cerebro.controllers.models.DnaRequest;
import com.magneto.cerebro.utils.sequenceFinder.builder.ISequenceFinderManagerBuilder;
import com.magneto.cerebro.utils.sequenceFinder.builder.SequenceFinderBuildDirector;
import com.magneto.cerebro.utils.sequenceFinder.SequenceFinderManager;
import com.magneto.cerebro.utils.sequenceFinder.builder.SequenceFinderManagerBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class CerebroController {

    @RequestMapping(method = POST)
    public HttpStatus mutant(@RequestBody DnaRequest dna) {
        ISequenceFinderManagerBuilder builder = new SequenceFinderManagerBuilder();
        SequenceFinderBuildDirector director = new SequenceFinderBuildDirector(builder);

        SequenceFinderManager manager = director.construct(dna.getDna(), 4);
        int foundCount = manager.foundSequences();

        if (foundCount > 1) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.FORBIDDEN;
        }

    }
}
