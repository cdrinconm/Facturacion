package com.facturacion.daycam.proveedores.impl;

import org.springframework.stereotype.Service;

import com.facturacion.daycam.proveedores.entities.ProveedorEntity;
import com.facturacion.daycam.proveedores.repositories.ProveedorRepository;
import com.facturacion.daycam.proveedores.services.ProveedorService;

@Service
public class ProveedorImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorImpl() {
        this.proveedorRepository = null;
    }

    @Override
    public Boolean guardarProveedor(ProveedorEntity proveedorEntity) {
        try { 
            proveedorRepository.save(proveedorEntity);
            return true; 
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public Boolean actualizarProveedor(ProveedorEntity proveedorEntity) {
        try {
            proveedorRepository.save(proveedorEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean desvincularProveedor(Long id) {
        try {
            if(id != null) {
                proveedorRepository.desvincularProveedor(id);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
    
}
