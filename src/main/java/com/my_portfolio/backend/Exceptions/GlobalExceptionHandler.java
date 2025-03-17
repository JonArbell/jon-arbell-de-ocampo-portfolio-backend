package com.my_portfolio.backend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String >> urlHandler(MethodArgumentNotValidException exception){

        var errors = new HashMap<String, String>();
        exception.getAllErrors().forEach(error ->
                errors.put(error.getCode()+" Error",error.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> generalExceptionHandler(Exception ex) {
        return new ResponseEntity<>(Map.of(ex.getClass().getSimpleName(),ex.getLocalizedMessage()),HttpStatus.BAD_REQUEST);
    }

}
