package com.my_portfolio.backend.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
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

    @PostMapping("/api/ping")
    public Map<String, String> checkPing(){
        return Map.of("Ping","Tamang ping lang");
    }

    @Scheduled(fixedRate = 300000) // 5 minutes
    public void ping() {

        try {

            var response = webClient.post()
                    .uri("/api/ping")
                    .retrieve()
                    .bodyToMono(Map.class);

            var result = response.block();

            logger.info("Ping successful, Result: {}", result);

        } catch (WebClientResponseException e) {

            logger.error("Ping failed with status {}: {}", e.getStatusCode(), e.getMessage());
        } catch (Exception e) {

            logger.error("Exception Error: {}", e.getMessage());
        }
    }

}
