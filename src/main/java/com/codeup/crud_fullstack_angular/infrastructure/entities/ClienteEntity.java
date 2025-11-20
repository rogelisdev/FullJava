package com.codeup.crud_fullstack_angular.infrastructure.entities;

import com.codeup.crud_fullstack_angular.domain.models.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    public ClienteEntity() {
    }

    public ClienteEntity(Long id, String nombre, String apellido, String email) {

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public static ClienteEntity fromDomainModel(Cliente cliente){
        return new ClienteEntity(cliente.getId(), cliente.getNombre(), cliente.getApellido(), cliente.getEmail());
    }

    public Cliente toDomainModel(){
        return new Cliente(id, nombre, apellido, email);
    }
}
