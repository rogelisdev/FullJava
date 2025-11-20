package com.codeup.crud_fullstack_angular.domain.ports.in;

import com.codeup.crud_fullstack_angular.domain.models.Cliente;

import java.util.Optional;

public interface ActualizarClienteUseCase {
    Optional<Cliente> actualizarCliente (Long id, Cliente cliente);
}
