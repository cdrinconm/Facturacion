package com.facturacion.daycam.productos.services;

import com.facturacion.daycam.productos.entities.ProductoEntity;


public interface  ProductoService {
    
    Boolean guardarProducto(ProductoEntity productoEntity);

    Boolean actualizarProducto(ProductoEntity productoEntity);

    Boolean desvincularProducto(Long id);
}
