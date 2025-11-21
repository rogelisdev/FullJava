package com.codeup.crud_fullstack_angular.infrastructure.repositories;

import com.codeup.crud_fullstack_angular.domain.models.Cliente;
import com.codeup.crud_fullstack_angular.domain.ports.out.ClienteRepositoryPort;
import com.codeup.crud_fullstack_angular.infrastructure.entities.ClienteEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final JpaClienteRepository jpaClienteRepository;

    public JpaClienteRepositoryAdapter(JpaClienteRepository jpaClienteRepository) {
        this.jpaClienteRepository = jpaClienteRepository;
    }


    @Override
    public Cliente crearCliente(Cliente cliente) {
        ClienteEntity entity = ClienteEntity.fromDomainModel(cliente);
        ClienteEntity guardaEntity = jpaClienteRepository.save(entity);
        return guardaEntity.toDomainModel();
    }

    @Override
    public Optional<Cliente> actualizarCliente(Cliente cliente) {
        if (jpaClienteRepository.existsById(cliente.getId())) {
            ClienteEntity entity = ClienteEntity.fromDomainModel(cliente);
            ClienteEntity actualizarEntity = jpaClienteRepository.save(entity);

            return Optional.of(actualizarEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return jpaClienteRepository.findAll().stream()
                .map(ClienteEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> obtenerPorId(Long id) {
        return jpaClienteRepository.findById(id)
                .map(ClienteEntity::toDomainModel);
    }

    @Override
    public boolean eliminarCliente(Long id) {
        if(jpaClienteRepository.existsById(id)){
            jpaClienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
