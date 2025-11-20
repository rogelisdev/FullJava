package com.codeup.crud_fullstack_angular.application.usecase;

import com.codeup.crud_fullstack_angular.domain.models.Cliente;
import com.codeup.crud_fullstack_angular.domain.ports.in.ObtenerClieneteUseCase;
import com.codeup.crud_fullstack_angular.domain.ports.out.ClienteRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ObtenerClienteUseCaseImpl implements ObtenerClieneteUseCase {

    private final ClienteRepositoryPort port;

    public ObtenerClienteUseCaseImpl(ClienteRepositoryPort port) {
        this.port = port;
    }


    @Override
    public Optional<Cliente> obtenerPorId(Long id) {
        return port.obtenerPorId(id);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return port.obtenerTodos();
    }
}
