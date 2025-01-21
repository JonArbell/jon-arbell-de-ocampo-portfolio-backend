package com.my_portfolio.backend.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;

@RestController
public class PingController {

    private final WebClient webClient;
    private final Logger logger = LoggerFactory.getLogger(PingController.class);

    public PingController(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("https://jon-arbell-de-ocampo-portfolio-backend.onrender.com").build();
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

            logger.info("Result : {}",result);

        } catch (Exception e) {
            logger.error("Exception Error : {}",e.getMessage());
        }

    }

}
