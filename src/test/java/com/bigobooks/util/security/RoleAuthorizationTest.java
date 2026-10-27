package com.bigobooks.util.security;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

class RoleAuthorizationTest {

	@AfterEach
	void clearSecurityContext() {
		SecurityContextHolder.clearContext();
	}

	@Test
	void checksRolesFromConfiguredPolicy() {
		var environment = new MockEnvironment()
				.withProperty("security.roles.orders-manage", "ADMIN,SELLER");
		var authorization = new RoleAuthorization(environment);
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken("user", "", List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))));

		assertTrue(authorization.allows("orders-manage"));
		assertFalse(authorization.allows("orders-delete"));
	}
}
