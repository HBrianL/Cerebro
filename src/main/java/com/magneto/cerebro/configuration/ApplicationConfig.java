package com.magneto.cerebro.configuration;

import com.magneto.cerebro.service.DnaService;
import com.magneto.cerebro.service.IDnaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.magneto.cerebro.repository")
class ApplicationConfig {
    @Bean
    public IDnaService dnaService() {
        return new DnaService();
    }
}
