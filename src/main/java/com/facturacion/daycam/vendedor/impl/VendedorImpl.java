package com.facturacion.daycam.vendedor.impl;

import org.springframework.stereotype.Service;

import com.facturacion.daycam.vendedor.entities.VendedorEntity;
import com.facturacion.daycam.vendedor.repositories.VendedorRepository;
import com.facturacion.daycam.vendedor.services.VendedorService;

@Service
public class VendedorImpl implements VendedorService {

    private final VendedorRepository vendedorRepository;

    public VendedorImpl() {
        this.vendedorRepository = null;
    }

    @Override
    public Boolean guardarVendedor(VendedorEntity vendedorEntity) {
        try { 
            vendedorRepository.save(vendedorEntity);
            return true; 
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public Boolean actualizarVendedor(VendedorEntity vendedorEntity) {
        try {
            vendedorRepository.save(vendedorEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean desvincularVendedor(Long id) {
        try {
            if(id != null) {
                vendedorRepository.desvincularVendedor(id);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
    
}
