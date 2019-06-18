package com.magneto.cerebro.configuration;

import com.magneto.cerebro.service.DnaService;
import com.magneto.cerebro.service.IDnaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@EnableJpaRepositories("com.magneto.cerebro.repository")
class ApplicationConfig {

    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("CerebroThreading-");
        executor.initialize();
        return executor;
    }

    @Bean
    public IDnaService dnaService() {
        return new DnaService();
    }
}
