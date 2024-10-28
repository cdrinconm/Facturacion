package com.facturacion.daycam.shared.interfaces;

/**
 * Interfaz que representa la estructura de un objeto identificable.
 * 
 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
 * @version 2024-07-01
 * @since 1.0.0
 */
public interface Identifiable {

	/**
	 * Método que obtiene el identificador.
	 * 
	 * @return Identificador.
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	public Long getId();

	/**
	 * Método que establece el identificador.
	 * 
	 * @param id
	 *          Parámetro que representa el identificador.
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	public void setId(final Long id);

}
