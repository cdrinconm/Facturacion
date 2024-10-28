package com.facturacion.daycam.productos.controllers;

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

import com.facturacion.daycam.productos.dto.ProductoActualizarDto;
import com.facturacion.daycam.productos.dto.ProductoGuardarDto;
import com.facturacion.daycam.productos.entities.ProductoEntity;

import static jakarta.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductoApi {

    public ProductoApi(com.facturacion.daycam.productos.services.ProductoService productoService) {
        this.productoService = productoService;
        this.modelMapper = new ModelMapper();
    }

    private final com.facturacion.daycam.productos.services.ProductoService productoService;
    private final ModelMapper modelMapper;

    @PostMapping("/guardarProducto")
    public ResponseEntity<com.facturacion.daycam.productos.entities.ProductoEntity> getProductoService(@RequestBody ProductoGuardarDto productoDto) {
        ProductoEntity productoEntity = modelMapper.map(productoDto, ProductoEntity.class);
        Boolean respuesta = productoService.guardarProducto(productoEntity);
        if (Boolean.TRUE.equals(respuesta)) {
            return ResponseEntity.ok(productoEntity);
        } else {
            return ResponseEntity.status(SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/actualizarProducto")
    public ResponseEntity<String> actualizarProducto(@RequestBody ProductoActualizarDto productoActualizarDto) {
        ProductoEntity productoEntity = modelMapper.map(productoActualizarDto,ProductoEntity.class);
        Boolean respuesta = productoService.actualizarProducto(productoEntity);
        if (Boolean.TRUE.equals(respuesta)) {
            return ResponseEntity.ok("Producto actualizado");
        } else {
            return ResponseEntity.status(SC_INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @GetMapping("/desvincularProducto/{id}")
    public ResponseEntity<String> desvincularProducto(@PathVariable Long id) {
        Boolean respuesta = productoService.desvincularProducto(id);
        if (Boolean.TRUE.equals(respuesta)) {
            return ResponseEntity.ok("Producto desvinculado");
        } else {
            return ResponseEntity.status(SC_INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
