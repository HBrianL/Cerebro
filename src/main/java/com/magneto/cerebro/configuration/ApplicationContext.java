package com.magneto.cerebro.configuration;

import com.magneto.cerebro.domain.DnaService;
import com.magneto.cerebro.domain.IDnaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContext {

    @Bean
    public IDnaService dnaService() {
        return new DnaService();
    }
}
