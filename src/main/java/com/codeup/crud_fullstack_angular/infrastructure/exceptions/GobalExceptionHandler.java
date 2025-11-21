package com.codeup.crud_fullstack_angular.infrastructure.exceptions;

import com.codeup.crud_fullstack_angular.application.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

// MANEJARLO FALTA INCORPORARLO EN EL PROYECTO

@RestControllerAdvice
public class GobalExceptionHandler {

    //Manejo de 404 not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException notFound,
                                                                        WebRequest webRequest) {
        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                notFound.getMessage(),
                webRequest.getDescription(false),
                "NOT FOUND"
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }






        /*   Map<String, Object> body = new HashMap<>();
        body.put("error", "NOT_FOUND");
        body.put("mensaje", notFound.getMessage());
        body.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    } */

    /* Manejo de 400 bad request por fallas de @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, ErrorDetails>> handleValidationExceptions(MethodArgumentNotValidException invalid){
        Map<String, Object> error = new HashMap<>();

        invalid.getBindingResult()
                .getFieldErrors()
                .forEach( e -> error.put(e.getField(), e.getDefaultMessage()));

        Map<String, Object> body = new HashMap<>();
        body.put("error", "BAD_REQUEST");
        body.put("mensajes", error);
        body.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    } */

