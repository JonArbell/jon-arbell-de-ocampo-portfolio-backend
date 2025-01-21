package com.my_portfolio.backend.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl("https://jon-arbell-de-ocampo-portfolio-backend.onrender.com").build();
    }

}
