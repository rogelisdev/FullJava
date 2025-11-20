package com.codeup.crud_fullstack_angular.application.usecase;

import com.codeup.crud_fullstack_angular.domain.models.Cliente;
import com.codeup.crud_fullstack_angular.domain.ports.in.ActualizarClienteUseCase;
import com.codeup.crud_fullstack_angular.domain.ports.out.ClienteRepositoryPort;

import java.util.Optional;

public class ActualizarClienteUseCaseImpl implements ActualizarClienteUseCase {

    private final ClienteRepositoryPort port;

    public ActualizarClienteUseCaseImpl(ClienteRepositoryPort port) {
        this.port = port;
    }


    @Override
    public Optional<Cliente> actualizarCliente(Long id, Cliente cliente) {
        return port.actualizarCliente(cliente);
    }
}
