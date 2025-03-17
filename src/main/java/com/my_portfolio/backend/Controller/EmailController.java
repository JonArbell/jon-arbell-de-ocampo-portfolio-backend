package com.my_portfolio.backend.Controller;

import com.my_portfolio.backend.Model.ModelDTO;
import com.my_portfolio.backend.Service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class EmailController {

    //URL = https://jon-arbell-de-ocampo-portfolio-backend.onrender.com/api/email-inquiry

    private final EmailService emailService;

    @CrossOrigin(origins = "https://deocampo-jon-arbell-d.netlify.app")
    @PostMapping("/api/email-inquiry")
    public ResponseEntity<Map<String, String>> sendContactEmail(@Valid @RequestBody ModelDTO modelDTO) {

        emailService.sendContactEmail(modelDTO);

        return new ResponseEntity<>(Map.of("Response email","Successfully"), HttpStatus.OK);

    }

}
