package com.facturacion.daycam.shared.security.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.hibernate.envers.Audited;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.facturacion.daycam.shared.interfaces.Revocable;
import com.facturacion.daycam.shared.usuario.entities.AuditableEntity;
import com.facturacion.daycam.shared.usuario.entities.UsuarioEntity;

/**
 * Clase que representa una autorización de un usuario.
 * 
 * @see gov.co.mindefensa.events.models.AuditableEntity
 * @see gov.co.mindefensa.events.interfaces.Revocable
 * @see gov.co.mindefensa.events.models.user.UserEntity
 * @see gov.co.mindefensa.events.models.LapseEmbeddable
 * 
 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
 * @version 2024-07-01
 * @since 1.0.0
 */
@Schema(name = "user:authorization", description = "Autorización de un usuario.")
@Entity(name = "user:authorization")
@Audited
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationEntity extends AuditableEntity implements Revocable {

	/**
	 * Propiedad que representa el usuario al que se le otorga la autorización.
	 * 
	 * @see gov.co.mindefensa.events.models.UserEntity
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Usuario al que se le otorga la autorización.")
	@ManyToOne
	@Getter(onMethod = @__(value = { @NonNull }))
	@Setter(onParam = @__(value = { @NonNull }))
	@JoinColumn(name = "user.id", nullable = false, updatable = false)
	private UsuarioEntity user;

	/**
	 * Propiedad que representa la dirección IP de la autorización.
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Dirección IP de la autorización.")
	@Getter(onMethod = @__(value = { @NonNull }))
	@Setter(onParam = @__(value = { @NonNull }))
	@Column(name = "address", nullable = false, updatable = false)
	private String address;

	/**
	 * Propiedad que representa el lapso de vida de la autorización.
	 * 
	 * @see gov.co.mindefensa.events.models.LapseEmbeddable
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Lapso de vida de la autorización.")
	@Embedded
	@Getter(onMethod = @__(value = { @NonNull }))
	@Setter(onParam = @__(value = { @NonNull }))
	@AttributeOverride(name = "from", column = @Column(name = "lifetime.from", nullable = false, updatable = false))
	@AttributeOverride(name = "to", column = @Column(name = "lifetime.to", nullable = false, updatable = false))
	private LapseEmbeddable lifetime;

	/**
	 * Propiedad que representa el estado de revocación de la autorización.
	 * 
	 * @see gov.co.mindefensa.events.interfaces.Revocable#getRevoked()
	 * @see gov.co.mindefensa.events.interfaces.Revocable#setRevoked(Boolean)
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Estado de revocación de la autorización.")
	@Default
	@Getter(onMethod = @__(value = { @NonNull }))
	@Setter(onParam = @__(value = { @NonNull }))
	@Column(name = "revoked", nullable = false)
	private Boolean revoked = false;

	/**
	 * Propiedad que representa el token de autorización de un usuario.
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Token de autorización.")
	@Getter(onMethod = @__(value = { @NonNull }))
	@Setter(onParam = @__(value = { @Nullable }))
	@Transient
	private String token;

}
