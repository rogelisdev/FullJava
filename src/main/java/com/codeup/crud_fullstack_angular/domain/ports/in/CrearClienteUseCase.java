package com.codeup.crud_fullstack_angular.domain.ports.in;

import com.codeup.crud_fullstack_angular.domain.models.Cliente;

public interface CrearClienteUseCase {
    Cliente crearCliente (Cliente cliente);
}
