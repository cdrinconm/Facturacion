package com.facturacion.daycam.vendedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.facturacion.daycam.vendedor.entities.VendedorEntity;

import jakarta.transaction.Transactional;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE VendedorEntity v SET v.desvincular = 'SI' WHERE v.id = ?1")
    void desvincularVendedor(Long id);
    
}
