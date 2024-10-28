package com.facturacion.daycam.shared.security.authorization;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.security.Key;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import com.facturacion.daycam.shared.security.entities.AuthorizationEntity;
import com.facturacion.daycam.shared.security.repositories.AuthorizationRepository;


/**
 * Clase que representa un componente para el filtrado de autorización de usuario.
 * 
 * @see gov.co.mindefensa.events.models.user.AuthorizationEntity
 * @see gov.co.mindefensa.events.repositories.user.AuthorizationRepository
 * 
 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
 * @version 2024-07-01
 * @since 1.0.0
 */
@Component(value = "component:user:authorization:filter")
@RequiredArgsConstructor(onConstructor = @__(value = { @Autowired }))
public class FilterComponent extends OncePerRequestFilter {

	/**
	 * Propiedad estática que representa el prefijo del valor del encabezado de autorización.
	 *
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@NonNull
	private static final String HeaderPrefix = "Bearer ";

	/**
	 * Propiedad que representa la clave de firma de la autorización.
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Value(value = "${user.authorization.signing-key}")
	private String signingKey;

	private final Key signingKeyNewKey = Keys.hmacShaKeyFor(signingKey.getBytes());

	

	/**
	 * Propiedad que representa el repositorio de autorizaciones.
	 * 
	 * @see gov.co.mindefensa.events.repositories.user.AuthorizationRepository
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@NonNull
	private final AuthorizationRepository authorizationRepository;

	/**
	 * Método que filtra las solicitudes autorizadas de los usuarios.
	 * 
	 * @param request
	 *          Parámetro que representa la solicitud HTTP.
	 * @param response
	 *          Parámetro que representa la respuesta HTTP.
	 * @param chain
	 *          Parámetro que representa la cadena de filtros.
	 * 
	 * @throws ResponseStatusException
	 *           Si no se suministra un encabezado de autorización o no comienza con el prefijo correcto.
	 * @throws ResponseStatusException
	 *           Si la autorización ha expirado, no es compatible, está mal formada, tiene una firma incorrecta o es ilegal.
	 * @throws ResponseStatusException
	 *           Si no se suministra una dirección IP o no coincide con la dirección IP registrada.
	 * @throws ResponseStatusException
	 *           Si no se encuentra la autorización.
	 * @throws ResponseStatusException
	 *           Si la autorización ha sido revocada.
	 * @throws ResponseStatusException
	 *           Si el usuario está deshabilitado.
	 * 
	 * @see gov.co.mindefensa.events.models.user.AuthorizationEntity
	 * @see gov.co.mindefensa.events.repositories.user.AuthorizationRepository#findById(Long)
	 * 
	 * @author <a href="mailto:josed.perez@mindefensa.gov.co">José Daniel Pérez Torres</a>
	 * @version 2024-07-01
	 * @since 1.0.0
	 */
	@Override
	protected void doFilterInternal(@NonNull final HttpServletRequest request, @NonNull final HttpServletResponse response, @NonNull final FilterChain chain) throws ServletException, IOException {
		Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
			.filter((@NonNull final String authorizationHeader) -> authorizationHeader.startsWith(HeaderPrefix))
			.map((@NonNull final String authorizationHeader) -> authorizationHeader.substring(HeaderPrefix.length()))
			.map((@NonNull final String authorizationToken) -> {
				try {
					
					return Jwts.parserBuilder()
						.setSigningKey(this.signingKeyNewKey)
						.build()
						.parseClaimsJws(authorizationToken)
						.getBody();
				} catch (final ExpiredJwtException | UnsupportedJwtException | MalformedJwtException  | IllegalArgumentException exception) {
					return null;
				}
			})
			.filter((@NonNull final Claims claims) -> Optional.ofNullable(RequestContextHolder.currentRequestAttributes())
				.map(ServletRequestAttributes.class::cast)
				.map(ServletRequestAttributes::getRequest)
				.map(HttpServletRequest::getRemoteAddr)
				.flatMap((@NonNull final String address) -> Optional.ofNullable(claims.get("rip", String.class)).map(address::equals))
				.orElse(false))
			.map(Claims::getId)
			.map(Long::parseLong)
			.flatMap(this.authorizationRepository::findById)
			.filter((@NonNull final AuthorizationEntity authorizationEntity) -> !authorizationEntity.getRevoked())
			.filter((@NonNull final AuthorizationEntity authorizationEntity) -> !authorizationEntity.getUser().getEstado().equals("inactivo"))
			.map((@NonNull final AuthorizationEntity authorizationEntity) -> new UsernamePasswordAuthenticationToken(authorizationEntity, null, List.of(new SimpleGrantedAuthority(authorizationEntity.getUser().getRol()))))
			.ifPresentOrElse((@NonNull final Authentication authentication) -> Optional.ofNullable(SecurityContextHolder.getContext())
				.ifPresent((@NonNull final SecurityContext securityContext) -> securityContext.setAuthentication(authentication)), SecurityContextHolder::clearContext);
		chain.doFilter(request, response);
	}

}
