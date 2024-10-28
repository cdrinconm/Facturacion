package com.facturacion.daycam.productos.impl;



import org.springframework.stereotype.Service;

import com.facturacion.daycam.productos.entities.ProductoEntity;
import com.facturacion.daycam.productos.repositories.ProductoRepository;
import com.facturacion.daycam.productos.services.ProductoService;

@Service
public class ProductoImpl implements ProductoService {

    private final  ProductoRepository productoRepository;

    public ProductoImpl() {
        this.productoRepository = null;
    }

    @Override
    public Boolean guardarProducto(ProductoEntity productoEntity) {
        try {
            productoRepository.save(productoEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean actualizarProducto(ProductoEntity productoEntity) {
        try {
            if (productoEntity != null) {
                productoRepository.save(productoEntity);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean desvincularProducto(Long id) {
        try {
            if (id != null) {
                productoRepository.desvincularProducto(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
}
