package com.codeup.crud_fullstack_angular.application.usecase;

import com.codeup.crud_fullstack_angular.domain.ports.in.EliminarClienteUseCase;
import com.codeup.crud_fullstack_angular.domain.ports.out.ClienteRepositoryPort;

public class EliminarClienteUseCaseImpl implements EliminarClienteUseCase {

    private final ClienteRepositoryPort port;

    public EliminarClienteUseCaseImpl(ClienteRepositoryPort port) {
        this.port = port;
    }


    @Override
    public boolean eliminarCliente(Long id) {
        return port.eliminarCliente(id);
    }
}
