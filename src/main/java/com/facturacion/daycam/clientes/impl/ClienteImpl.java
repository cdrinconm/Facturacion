package com.facturacion.daycam.clientes.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.facturacion.daycam.clientes.entities.ClienteEntity;
import com.facturacion.daycam.clientes.repositories.ClienteRepository;
import com.facturacion.daycam.clientes.services.ClienteService;


@Service
public class ClienteImpl implements ClienteService {

    public ClienteImpl(com.facturacion.daycam.clientes.repositories.ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private final ClienteRepository clienteRepository;

    @Override
    public Boolean guardarCliente(ClienteEntity clienteEntity) {
        try {
            clienteRepository.save(clienteEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public Boolean actualizarCliente(ClienteEntity clienteEntity) {
        if (clienteEntity != null) {
            clienteRepository.save(clienteEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean desvincularCliente(Long id) {
        try {
            if (id != null) {
                clienteRepository.desvincularCliente(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

}
