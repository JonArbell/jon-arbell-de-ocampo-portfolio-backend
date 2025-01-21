package com.my_portfolio.backend.Controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;

@RestController
public class PingController {

    private final WebClient webClient;

    public PingController(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    @Scheduled(fixedRate = 300000)
    public void ping(){

        var body = Map.of("email","","fullName","","message","");

        try {
            Mono<String> response = webClient.post()
                    .uri("/api/email-inquiry")
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(String.class);


            String result = response.block();
            System.out.println("Ping successful: " + result);

        } catch (Exception e) {

            System.err.println("Ping failed: " + e.getMessage());
        }

    }

}
