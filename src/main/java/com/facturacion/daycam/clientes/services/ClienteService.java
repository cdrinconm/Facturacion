package com.facturacion.daycam.clientes.services;

import com.facturacion.daycam.clientes.entities.ClienteEntity;

public interface ClienteService {
    
    Boolean guardarCliente(ClienteEntity clienteEntity);

    Boolean actualizarCliente(ClienteEntity clienteEntity);

    Boolean desvincularCliente(Long id);
}
