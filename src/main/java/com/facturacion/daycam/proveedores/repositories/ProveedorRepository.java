package com.facturacion.daycam.proveedores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.facturacion.daycam.proveedores.entities.ProveedorEntity;

import jakarta.transaction.Transactional;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE ProveedorEntity p SET p.desvincular = 'SI' WHERE p.id = ?1")
    void desvincularProveedor(Long id);
    
}
