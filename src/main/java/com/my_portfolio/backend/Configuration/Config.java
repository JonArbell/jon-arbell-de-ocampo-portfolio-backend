package com.my_portfolio.backend.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class Config {

    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);  // Initial number of threads in the pool
        executor.setMaxPoolSize(10);  // Maximum number of threads in the pool
        executor.setQueueCapacity(25);  // Size of the queue to hold tasks before they are executed
        executor.setThreadNamePrefix("Async-");  // Prefix for thread names
        executor.initialize();
        return executor;
    }
}
