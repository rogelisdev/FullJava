package com.codeup.crud_fullstack_angular.infrastructure.repositories;

import com.codeup.crud_fullstack_angular.infrastructure.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
