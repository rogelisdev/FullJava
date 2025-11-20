package com.codeup.crud_fullstack_angular.domain.ports.in;

import org.springframework.context.annotation.Bean;

public interface EliminarClienteUseCase {
    boolean eliminarCliente(Long id);
}
