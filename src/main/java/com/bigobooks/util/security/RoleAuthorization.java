package com.bigobooks.util.security;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("roles")
public class RoleAuthorization {

	private final Environment environment;

	public RoleAuthorization(Environment environment) {
		this.environment = environment;
	}

	@SuppressWarnings("null")
	public boolean allows(String policy) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null) {
			return false;
		}

		String configuredRoles = environment.getProperty("security.roles." + policy, "");

		Set<String> authorities = authentication.getAuthorities().stream()
				.map(authority -> authority.getAuthority())
				.map(RoleAuthorization::canonical)
				.collect(Collectors.toSet());

		return Arrays.stream(configuredRoles.split(","))
				.map(RoleAuthorization::canonical)
				.anyMatch(role -> authorities.contains(role) || authorities.contains("ADMIN"));
	}

	/**
	 * La base de demo usa SALLER para vendedor y Compras usa VENDEDOR; otros
	 * modulos usan SELLER. Se normalizan para que los tres alias representen
	 * el mismo rol sin duplicar permisos en cada application.properties.
	 */
	private static String canonical(String role) {
		String normalized = role == null ? "" : role.trim().toUpperCase(Locale.ROOT);
		if (normalized.startsWith("ROLE_")) {
			normalized = normalized.substring("ROLE_".length());
		}
		return switch (normalized) {
			case "SALLER", "VENDEDOR" -> "SELLER";
			default -> normalized;
		};
	}
}
