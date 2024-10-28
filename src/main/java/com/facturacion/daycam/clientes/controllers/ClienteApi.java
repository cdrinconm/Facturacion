package com.facturacion.daycam.clientes.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.daycam.clientes.dto.ClienteActualizarDto;
import com.facturacion.daycam.clientes.dto.ClienteGuardarDto;
import com.facturacion.daycam.clientes.entities.ClienteEntity;
import com.facturacion.daycam.clientes.services.ClienteService;

import static jakarta.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClienteApi {

    public ClienteApi(com.facturacion.daycam.clientes.services.ClienteService clienteService) {
        this.clienteService = clienteService;
        this.modelMapper = new ModelMapper();
    }
    
    private final ClienteService clienteService;

    private final ModelMapper modelMapper;


    @PostMapping("/guardarCliente")
    public ResponseEntity<ClienteEntity> getClienteService(@RequestBody ClienteGuardarDto clienteDto) {
        ClienteEntity clienteEntity = modelMapper.map(clienteDto, ClienteEntity.class);
        Boolean respuesta = clienteService.guardarCliente(clienteEntity);
        if (Boolean.TRUE.equals(respuesta)) {
            return ResponseEntity.ok(clienteEntity);
        } else {
            return ResponseEntity.status(SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/actualizarCliente")
    public ResponseEntity<String> actualizarCliente(@RequestBody ClienteActualizarDto clienteActualizarDto) {
        ClienteEntity clienteEntity = modelMapper.map(clienteActualizarDto, ClienteEntity.class);
        Boolean respuesta = clienteService.actualizarCliente(clienteEntity);
        if (Boolean.TRUE.equals(respuesta)) {
            return ResponseEntity.ok("Cliente actualizado");
        } else {
            return ResponseEntity.status(SC_INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @GetMapping("/desvincularCliente/{id}")
    public ResponseEntity<String> desvincularCliente(@PathVariable Long id) {
        Boolean respuesta = clienteService.desvincularCliente(id);
        if (Boolean.TRUE.equals(respuesta)) {
            return ResponseEntity.ok("Cliente desvinculado");
        } else {
            return ResponseEntity.status(SC_INTERNAL_SERVER_ERROR).build();
        }
        
    }
}
