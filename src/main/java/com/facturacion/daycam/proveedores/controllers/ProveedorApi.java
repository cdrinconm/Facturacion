package com.facturacion.daycam.proveedores.controllers;


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

import com.facturacion.daycam.proveedores.dto.ProveedorActualizarDto;
import com.facturacion.daycam.proveedores.dto.ProveedorGuardarDto;
import com.facturacion.daycam.proveedores.entities.ProveedorEntity;
import com.facturacion.daycam.proveedores.services.ProveedorService;



@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ProveedorApi {
  

    private final ProveedorService proveedorService;
    private final ModelMapper modelMapper;

    public ProveedorApi() {
        this.proveedorService = null;
        this.modelMapper = null;
    }


  
    @PostMapping("/guardarProveedor")
    public ResponseEntity<ProveedorEntity> guardarProveedor(@RequestBody ProveedorGuardarDto proveedorGuardarDto) {
        ProveedorEntity proveedorEntity = modelMapper.map(proveedorGuardarDto, ProveedorEntity.class);
        Boolean valor = proveedorService.guardarProveedor(proveedorEntity);
        if(Boolean.TRUE.equals(valor)) {
            return ResponseEntity.ok(proveedorEntity);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizarProveedor")
    public ResponseEntity<String> actualizarProveedor(@RequestBody ProveedorActualizarDto proveedorGuardarDto) {
        ProveedorEntity proveedorEntity = modelMapper.map(proveedorGuardarDto, ProveedorEntity.class);
        Boolean valor = proveedorService.actualizarProveedor(proveedorEntity);
        if(Boolean.TRUE.equals(valor)) {
            return ResponseEntity.ok("Proveedor actualizado");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/desvincularProveedor/{id}")
    public ResponseEntity<String> desvincularProveedor(@PathVariable Long id) {
        Boolean valor = proveedorService.desvincularProveedor(id);
        if(Boolean.TRUE.equals(valor)) {
            return ResponseEntity.ok("Proveedor desvinculado");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
