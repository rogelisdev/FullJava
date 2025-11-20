package com.codeup.crud_fullstack_angular.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClienteResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
}
