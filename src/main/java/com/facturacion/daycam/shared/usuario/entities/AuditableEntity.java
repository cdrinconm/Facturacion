package com.facturacion.daycam.shared.usuario.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.facturacion.daycam.shared.interfaces.Identifiable;
import com.facturacion.daycam.shared.security.entities.AuthorizationEntity;

/**
 * Clase abstracta que representa un objeto auditado.
 * 
 * @see gov.co.mindefensa.events.interfaces.Identifiable
 * @see gov.co.mindefensa.events.models.user.AuthorizationEntity
 * 
 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
 * @version 2024-07-01
 * @since 1.0.0
 */
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity implements Identifiable {

	/**
	 * Propiedad que representa el identificador único.
	 * 
	 * @see gov.co.mindefensa.events.interfaces.Identifiable#getId()
	 * @see gov.co.mindefensa.events.interfaces.Identifiable#setId(Long)
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Identificador único.")
	@Getter(onMethod = @__(value = { @Nullable }))
	@Setter(onParam = @__(value = { @Nullable }))
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	/**
	 * Propiedad que representa la autorización de creación.
	 * 
	 * @see gov.co.mindefensa.events.models.user.AuthorizationEntity
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Autorización de creación.")
	@JsonIgnore
	@CreatedBy
	@Getter(onMethod = @__(value = { @Nullable }))
	@Setter(onParam = @__(value = { @Nullable }))
	@ManyToOne
	@JoinColumn(name = "creator.id", nullable = true, updatable = false)
	private AuthorizationEntity creator;

	/**
	 * Propiedad que representa la fecha y hora de creación.
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Fecha y hora de creación.")
	@JsonIgnore
	@CreatedDate
	@Getter(onMethod = @__(value = { @NonNull }))
	@Setter(onParam = @__(value = { @NonNull }))
	@Column(name = "creation", nullable = false, updatable = false)
	private LocalDateTime creation;

	/**
	 * Propiedad que representa la autorización de modificación.
	 * 
	 * @see gov.co.mindefensa.events.models.user.AuthorizationEntity
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Autorización de modificación.")
	@JsonIgnore
	@LastModifiedBy
	@Getter(onMethod = @__(value = { @Nullable }))
	@Setter(onParam = @__(value = { @Nullable }))
	@ManyToOne
	@JoinColumn(name = "modifier.id", nullable = true)
	private AuthorizationEntity modifier;

	/**
	 * Propiedad que representa la fecha y hora de modificación.
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Fecha y hora de modificación.")
	@JsonIgnore
	@LastModifiedDate
	@Getter(onMethod = @__(value = { @NonNull }))
	@Setter(onParam = @__(value = { @NonNull }))
	@Column(name = "modification", nullable = false)
	private LocalDateTime modification;

}
