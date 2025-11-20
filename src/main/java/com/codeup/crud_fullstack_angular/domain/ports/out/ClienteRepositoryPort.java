package com.codeup.crud_fullstack_angular.domain.ports.out;

import com.codeup.crud_fullstack_angular.domain.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {
Cliente crearCliente(Cliente cliente);
Optional<Cliente> actualizarCliente (Cliente cliente);
List<Cliente> obtenerTodos();
Optional<Cliente> obtenerPorId(Long id);
boolean eliminarCliente(Long id);

}
