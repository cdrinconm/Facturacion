package com.facturacion.daycam.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.facturacion.daycam.clientes.entities.ClienteEntity;

import jakarta.transaction.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    @Transactional
    @Modifying
    @Query  ("UPDATE ClienteEntity c SET c.desvincular = 'SI' WHERE c.id = ?1")
    void desvincularCliente(Long id);
    
}