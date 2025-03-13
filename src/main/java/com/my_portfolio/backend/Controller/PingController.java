package com.my_portfolio.backend.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import java.util.Map;

@RestController
public class PingController {

    private final WebClient webClient;
    private final Logger logger = LoggerFactory.getLogger(PingController.class);

    public PingController(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("https://jon-arbell-de-ocampo-portfolio-backend.onrender.com").build();
    }

    @CrossOrigin(origins = "https://jon-arbell-de-ocampo-portfolio-backend.onrender.com")
    @PostMapping("/api/ping")
    public Map<String, String> checkPing(){
        return Map.of("Ping","Tamang ping lang");
    }

    @Async
    @Scheduled(fixedRate = 300000) // 5 minutes
    public void ping() {

        webClient.post()
            .uri("/api/ping")
            .retrieve()
            .bodyToMono(Map.class)
            .subscribe(
                    result -> logger.info("Ping successful, Result: {}", result),
                    error -> {
                        if (error instanceof WebClientResponseException webClientException) {
                            logger.error("Ping failed with status {}: {}", webClientException.getStatusCode(), webClientException.getMessage());
                        } else {
                            logger.error("Exception Error: {}", error.getMessage());
                        }
                    }
            );
    }

}
