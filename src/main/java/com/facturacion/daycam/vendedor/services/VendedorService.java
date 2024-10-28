package com.facturacion.daycam.vendedor.services;

import com.facturacion.daycam.vendedor.entities.VendedorEntity;

public interface VendedorService {
    Boolean guardarVendedor(VendedorEntity vendedorEntity);
    Boolean actualizarVendedor(VendedorEntity vendedorEntity);
    Boolean desvincularVendedor(Long id);
}
