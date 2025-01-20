package com.my_portfolio.backend.Controller;

import com.my_portfolio.backend.Model.EmailModel;
import com.my_portfolio.backend.Service.EmailService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;


@Data
@RestController
public class EmailController {

    private final EmailService emailService;
    private final Logger logger = LoggerFactory.getLogger(EmailController.class);

    //URL = https://jon-arbell-de-ocampo-portfolio-backend.onrender.com/api/email-inquiry

    @CrossOrigin(origins = "https://deocampo-jon-arbell-d.netlify.app")
    @PostMapping("/api/email-inquiry")
    public ResponseEntity<Map<Object, Object>> sendContactEmail(@Validated @RequestBody EmailModel emailModel,
                                                                BindingResult bindingResult) {
        var response = new HashMap<>();

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(error -> {
                response.put("Error",error.getDefaultMessage());
            });

            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }

        try{
            logger.info("Feedback : {}",emailModel);
            emailService.sendContactEmail(emailModel);

            response.put("Response email","Successfully");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            response.put("error",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
