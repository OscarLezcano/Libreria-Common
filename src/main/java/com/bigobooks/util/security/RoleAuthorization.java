package com.bigobooks.util.security;

import java.util.Arrays;

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

	public boolean allows(String policy) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}

		String prefix = environment.getProperty("security.jwt.authority-prefix", "ROLE_");
		String configuredRoles = environment.getProperty("security.roles." + policy, "");
		return Arrays.stream(configuredRoles.split(","))
				.map(String::trim)
				.anyMatch(role -> authentication.getAuthorities().stream()
						.anyMatch(authority -> (prefix + role).equals(authority.getAuthority())));
	}
}
