package com.codeup.crud_fullstack_angular.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequest {

    @NotBlank(message = "Nombre obligatorio")
    @Size(min = 3, max = 30, message = "El nombre debe contener entre 3-30 caracteres")
    @Schema(description = "El nombre del cliente", examples = "Mathias", required = true)
    private String nombre;

    @NotBlank(message = "Apellido obligatorio")
    @Size(min = 3, max = 30, message = "El apellido debe contener entre 3-30 caracteres")
    @Schema(description = "El apellido del cliente", examples = "Garcia", required = true)
    private String apellido;

    @NotBlank(message = "Email obligatorio")
    @Size(min = 3, max = 30, message = "El email debe contener entre 3-30 caracteres")
    @Schema(description = "El email del cliente", examples = "mat@example.com", required = true)
    private String email;

}
