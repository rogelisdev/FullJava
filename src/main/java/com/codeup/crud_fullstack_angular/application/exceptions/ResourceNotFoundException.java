package com.codeup.crud_fullstack_angular.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// MANEJARLO FALTA INCORPORARLO EN EL PROYECTO
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String messege){
        super(messege);
    }
}
