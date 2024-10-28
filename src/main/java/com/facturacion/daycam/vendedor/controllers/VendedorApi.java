package com.facturacion.daycam.vendedor.controllers;


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

import com.facturacion.daycam.vendedor.dto.VendedorActualizarDto;
import com.facturacion.daycam.vendedor.dto.VendedorGuardarDto;
import com.facturacion.daycam.vendedor.entities.VendedorEntity;
import com.facturacion.daycam.vendedor.services.VendedorService;





@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class VendedorApi {
  

    private final VendedorService vendedorService;
    private final ModelMapper modelMapper;

    public VendedorApi() {
        this.vendedorService = null;
        this.modelMapper = null;
    }


  
    @PostMapping("/guardarVendedor")
    public ResponseEntity<VendedorEntity> guardarVendedor(@RequestBody VendedorGuardarDto vendedorGuardarDto) {
        VendedorEntity vendedorEntity = modelMapper.map(vendedorGuardarDto, VendedorEntity.class);
        Boolean valor = vendedorService.guardarVendedor(vendedorEntity);
        if(Boolean.TRUE.equals(valor)) {
            return ResponseEntity.ok(vendedorEntity);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizarVendedor")
    public ResponseEntity<String> actualizarVendedor(@RequestBody VendedorActualizarDto vendedorGuardarDto) {
        VendedorEntity vendedorEntity = modelMapper.map(vendedorGuardarDto, VendedorEntity.class);
        Boolean valor = vendedorService.actualizarVendedor(vendedorEntity);
        if(Boolean.TRUE.equals(valor)) {
            return ResponseEntity.ok("Proveedor actualizado");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/desvincularVendedor/{id}")
    public ResponseEntity<String> desvincularVendedor(@PathVariable Long id) {
        Boolean valor = vendedorService.desvincularVendedor(id);
        if(Boolean.TRUE.equals(valor)) {
            return ResponseEntity.ok("Proveedor desvinculado");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
