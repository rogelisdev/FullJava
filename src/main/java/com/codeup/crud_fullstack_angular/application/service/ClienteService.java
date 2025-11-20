package com.codeup.crud_fullstack_angular.application.service;

import com.codeup.crud_fullstack_angular.domain.models.Cliente;
import com.codeup.crud_fullstack_angular.domain.ports.in.ActualizarClienteUseCase;
import com.codeup.crud_fullstack_angular.domain.ports.in.CrearClienteUseCase;
import com.codeup.crud_fullstack_angular.domain.ports.in.EliminarClienteUseCase;
import com.codeup.crud_fullstack_angular.domain.ports.in.ObtenerClieneteUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements CrearClienteUseCase, ActualizarClienteUseCase, EliminarClienteUseCase, ObtenerClieneteUseCase {
    private final CrearClienteUseCase crear;
    private final ActualizarClienteUseCase actualizar;
    private final EliminarClienteUseCase eliminar;
    private final ObtenerClieneteUseCase obtener;

    public ClienteService(CrearClienteUseCase crear, ActualizarClienteUseCase actualizar, EliminarClienteUseCase eliminar, ObtenerClieneteUseCase obtener) {
        this.crear = crear;
        this.actualizar = actualizar;
        this.eliminar = eliminar;
        this.obtener = obtener;
    }


    @Override
    public Optional<Cliente> actualizarCliente(Long id, Cliente cliente) {
        return actualizar.actualizarCliente(id, cliente);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return crear.crearCliente(cliente);
    }

    @Override
    public boolean eliminarCliente(Long id) {
        return eliminar.eliminarCliente(id);
    }

    @Override
    public Optional<Cliente> obtenerPorId(Long id) {
        return obtener.obtenerPorId(id);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return obtener.obtenerTodos();
    }
}
