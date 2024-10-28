package com.facturacion.daycam.proveedores.services;

import com.facturacion.daycam.proveedores.entities.ProveedorEntity;

public interface ProveedorService {
    Boolean guardarProveedor(ProveedorEntity proveedorEntity);
    Boolean actualizarProveedor(ProveedorEntity proveedorEntity);
    Boolean desvincularProveedor(Long id);
}
