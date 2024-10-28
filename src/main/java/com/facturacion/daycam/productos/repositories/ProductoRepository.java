package com.facturacion.daycam.productos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.facturacion.daycam.productos.entities.ProductoEntity;

import jakarta.transaction.Transactional;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE ProductoEntity p SET p.desvincular = 'SI' WHERE p.id = ?1")
    void desvincularProducto(Long id);

}
