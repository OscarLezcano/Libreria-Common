package com.bigobooks.util.security;

import java.nio.charset.StandardCharsets;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

public final class JwtSecuritySupport {

	private JwtSecuritySupport() {
	}

	public static JwtAuthenticationConverter authenticationConverter(String authoritiesClaim, String authorityPrefix) {
		JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
		authoritiesConverter.setAuthoritiesClaimName(authoritiesClaim);
		authoritiesConverter.setAuthorityPrefix(authorityPrefix);

		JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
		converter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);
		return converter;
	}

	public static JwtDecoder decoder(String secret) {
		return NimbusJwtDecoder.withSecretKey(
				new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA512"))
				.macAlgorithm(MacAlgorithm.HS512)
				.build();
	}
}
