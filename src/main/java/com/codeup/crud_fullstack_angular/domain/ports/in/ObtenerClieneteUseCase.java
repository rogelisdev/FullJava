package com.codeup.crud_fullstack_angular.domain.ports.in;

import com.codeup.crud_fullstack_angular.domain.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ObtenerClieneteUseCase {
    Optional<Cliente> obtenerPorId(Long id);
    List<Cliente> obtenerTodos();
}
