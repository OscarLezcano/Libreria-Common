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
	void clearContext() {
		SecurityContextHolder.clearContext();
	}

	@Test
	void sallerYVendedorSonEquivalentesASeller() {
		MockEnvironment environment = new MockEnvironment()
				.withProperty("security.roles.purchases-view", "VENDEDOR");
		RoleAuthorization roles = new RoleAuthorization(environment);
		authenticate("ROLE_SALLER");

		assertTrue(roles.allows("purchases-view"));
	}

	@Test
	void sellerTambienCoincideConVendedor() {
		MockEnvironment environment = new MockEnvironment()
				.withProperty("security.roles.coupons-manage", "SELLER");
		RoleAuthorization roles = new RoleAuthorization(environment);
		authenticate("ROLE_VENDEDOR");

		assertTrue(roles.allows("coupons-manage"));
	}

	@Test
	void clienteNoAccedeAPoliticaDeVendedor() {
		MockEnvironment environment = new MockEnvironment()
				.withProperty("security.roles.stock-view", "SELLER");
		RoleAuthorization roles = new RoleAuthorization(environment);
		authenticate("ROLE_CLIENT");

		assertFalse(roles.allows("stock-view"));
	}

	@Test
	void adminAccedeATodo() {
		MockEnvironment environment = new MockEnvironment()
				.withProperty("security.roles.coupons-delete", "ADMIN");
		RoleAuthorization roles = new RoleAuthorization(environment);
		authenticate("ROLE_ADMIN");

		assertTrue(roles.allows("coupons-delete"));
	}

	private void authenticate(String authority) {
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken("test", null,
						List.of(new SimpleGrantedAuthority(authority))));
	}
}
