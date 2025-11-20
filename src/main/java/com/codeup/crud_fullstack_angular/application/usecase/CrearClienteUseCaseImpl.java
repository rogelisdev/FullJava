package com.codeup.crud_fullstack_angular.application.usecase;

import com.codeup.crud_fullstack_angular.domain.models.Cliente;
import com.codeup.crud_fullstack_angular.domain.ports.in.CrearClienteUseCase;
import com.codeup.crud_fullstack_angular.domain.ports.out.ClienteRepositoryPort;

public class CrearClienteUseCaseImpl implements CrearClienteUseCase {

    private final ClienteRepositoryPort port;

    public CrearClienteUseCaseImpl(ClienteRepositoryPort port) {
        this.port = port;
    }


    @Override
    public Cliente crearCliente(Cliente cliente) {
        return port.crearCliente(cliente);
    }
}
