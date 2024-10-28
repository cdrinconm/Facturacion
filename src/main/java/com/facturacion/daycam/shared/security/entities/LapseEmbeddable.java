package com.facturacion.daycam.shared.security.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.springframework.lang.NonNull;

/**
 * Clase que representa un lapso.
 * 
 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
 * @version 2024-07-01
 * @since 1.0.0
 */
@Schema(name = "lapse", description = "Lapso.")
@Embeddable
@Audited
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LapseEmbeddable {

	/**
	 * Propiedad que representa el límite inferior del lapso.
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Limite inferior del lapso.")
	@Getter(onMethod = @__(value = { @NonNull }))
	@Setter(onParam = @__(value = { @NonNull }))
	@Column(name = "from", nullable = false)
	private LocalDateTime from;

	/**
	 * Propiedad que representa el límite superior del lapso.
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Schema(description = "Limite superior del lapso.")
	@Getter(onMethod = @__(value = { @NonNull }))
	@Setter(onParam = @__(value = { @NonNull }))
	@Column(name = "to", nullable = false)
	private LocalDateTime to;

}
