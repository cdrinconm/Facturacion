package com.facturacion.daycam.shared.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.history.RevisionRepository;

import com.facturacion.daycam.shared.usuario.entities.AuditableEntity;

/**
 * Interfaz que representa la estructura de un repositorio mutable.
 * 
 * @param T
 *          Parámetro que representa el ipo de entidad.
 * 
 * @see gov.co.mindefensa.events.models.AuditableEntity
 * 
 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
 * @version 2024-07-01
 * @since 1.0.0
 */
@NoRepositoryBean
public interface MutableRepository<T extends AuditableEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T>, RevisionRepository<T, Long, Long> {

}
