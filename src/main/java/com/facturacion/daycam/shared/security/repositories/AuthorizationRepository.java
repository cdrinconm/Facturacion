package com.facturacion.daycam.shared.security.repositories;

import org.springframework.stereotype.Repository;

import com.facturacion.daycam.shared.security.entities.AuthorizationEntity;

/**
 * Interfaz que representa la estructura de un repositorios de autorizaciones de usuarios.
 * 
 * @see gov.co.mindefensa.events.models.user.AuthorizationEntity
 * @see gov.co.mindefensa.events.repositories.MutableRepository
 * 
 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
 * @version 2024-07-01
 * @since 1.0.0
 */
@Repository(value = "repository:user:authorization")
public interface AuthorizationRepository extends MutableRepository<AuthorizationEntity> {

}
