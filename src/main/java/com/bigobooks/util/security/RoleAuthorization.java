package com.bigobooks.util.security;

import java.util.Arrays;
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
				.collect(Collectors.toSet());

		return Arrays.stream(configuredRoles.split(","))
				.map(String::trim)
				.map(role -> "ROLE_" + role)
				.anyMatch(role -> authorities.contains(role) || authorities.contains("ROLE_ADMIN"));
	}
}
