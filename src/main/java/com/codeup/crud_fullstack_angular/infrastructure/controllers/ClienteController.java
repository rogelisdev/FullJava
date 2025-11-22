package com.codeup.crud_fullstack_angular.infrastructure.controllers;

import com.codeup.crud_fullstack_angular.application.service.ClienteService;
import com.codeup.crud_fullstack_angular.domain.models.Cliente;
import com.codeup.crud_fullstack_angular.application.dto.ClienteRequest;
import com.codeup.crud_fullstack_angular.application.dto.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200/")

public class ClienteController {

    private final ClienteService servicio;

    public ClienteController(ClienteService servicio) {
        this.servicio = servicio;
    }

    //----------------------- CREAR CLIENTE
    @Operation(summary = "Agregar un cliente", description = "Crear cliente y lo registra en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente",
            content = @Content(mediaType = "application/json",
            examples = @ExampleObject(
                    value = "{\"id\":\"1,\"nombre\":\"Mathias\"apellido\":\"Garcia\"email\":\"mat@gmail.com}"
            ))),
            @ApiResponse(responseCode = "400", description = "Datos invalidos")
    })
    @PostMapping
    public ResponseEntity<Cliente> crear(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos del cliente al crear",
            required = true,
            content = @Content(schema = @Schema(implementation = ClienteRequest.class),
            examples = @ExampleObject(
                    value = "{\"id\":\"1,\"nombre\":\"Mathias\"apellido\":\"Garcia\"email\":\"mat@gmail.com}"
            ))) @Valid @RequestBody Cliente cliente){
        Cliente crearCliente = servicio.crearCliente(cliente);
        return new ResponseEntity<>(crearCliente, HttpStatus.CREATED);
    }




    //----------------------- OBTENER POR ID CLIENTES
    @Operation(summary = "Obtener cliente por id", description = "Retorna el cliente con el id especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente obtenido exitosamente",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ClienteResponse.class),
                            examples = @ExampleObject(
                                    value = "{\"id\":\"1,\"nombre\":\"Mathias\"apellido\":\"Garcia\"email\":\"mat@gmail.com}"
                            ))),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado",
            content = @Content(mediaType = "application/json",
            examples = @ExampleObject(
                    value = "{\"mensaje\":\"Cliente con el id 1 no encontrado\"}"
            )))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerId(@Parameter(description = "id del evento a buscar", example = "1") @PathVariable Long id){
        return servicio.obtenerPorId(id)
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




    //----------------------- OBTENER TODOS LOS CLIENTES
    @Operation(summary = "obtener todos los clientes", description = "Retornar todos los clientes registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de clientes obtenidos exitosamente",
            content = @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))))
    })
    @GetMapping
    public ResponseEntity<Cliente> obtenerTodos(){
        List<Cliente> cliente = servicio.obtenerTodos();
        return new ResponseEntity(cliente, HttpStatus.OK);
    }





    //----------------------- ACTUALIZAR CLIENTE
    @Operation(summary = "Actualizar cliente", description = "Actualizar los datos de un cliente existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos invalidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente){
        return servicio.actualizarCliente(id, cliente)
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




    //----------------------- ELIMINAR CLIENTE
    @Operation(summary = "Eliminar cliente", description = "Eliminar un cliente existente por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id){
        if(servicio.eliminarCliente(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
