package com.codeup.crud_fullstack_angular.infrastructure.config;

import com.codeup.crud_fullstack_angular.application.service.ClienteService;
import com.codeup.crud_fullstack_angular.application.usecase.ActualizarClienteUseCaseImpl;
import com.codeup.crud_fullstack_angular.application.usecase.CrearClienteUseCaseImpl;
import com.codeup.crud_fullstack_angular.application.usecase.EliminarClienteUseCaseImpl;
import com.codeup.crud_fullstack_angular.application.usecase.ObtenerClienteUseCaseImpl;
import com.codeup.crud_fullstack_angular.domain.ports.out.ClienteRepositoryPort;
import com.codeup.crud_fullstack_angular.infrastructure.entities.ClienteEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ClienteService servicio(ClienteRepositoryPort repositoryPort){
        return  new ClienteService(
                new CrearClienteUseCaseImpl(repositoryPort),
                new ActualizarClienteUseCaseImpl(repositoryPort),
                new EliminarClienteUseCaseImpl(repositoryPort),
                new ObtenerClienteUseCaseImpl(repositoryPort)
        );
    }
}
