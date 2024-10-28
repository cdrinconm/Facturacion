package com.facturacion.daycam.shared.interfaces;

/**
 * Interfaz que representa la estructura de un objeto revocable.
 * 
 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
 * @version 2024-07-01
 * @since 1.0.0
 */
public interface Revocable {

	/**
	 * Método que obtiene el estado de revocación.
	 * 
	 * @return Estado de revocación.
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	public Boolean getRevoked();

	/**
	 * Método que establece el estado de revocación.
	 * 
	 * @param revoked
	 *          Parámetro que representa el estado de revocación.
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	public void setRevoked(final Boolean revoked);

}
