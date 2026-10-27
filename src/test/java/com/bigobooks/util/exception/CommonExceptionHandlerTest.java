package com.bigobooks.util.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class CommonExceptionHandlerTest {

	private final CommonExceptionHandler handler = new CommonExceptionHandler();

	@Test
	void returnsSharedErrorDtoAndStatusForApiException() {
		var response = handler.handleApiException(new ApiException(HttpStatus.NOT_FOUND, "Recurso inexistente"));

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals("Recurso inexistente", response.getBody().getMessage());
	}

	@Test
	void returnsNotFoundStatusForNotFoundException() {
		var response = handler.handleApiException(NotFoundException.byId(ResourceType.PURCHASE, 5L));

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals("No se encontró compra con id 5", response.getBody().getMessage());
	}

	@Test
	void returnsConflictStatusForConflictException() {
		var response = handler.handleApiException(new ConflictException("La compra ya esta en el estado RECEIVED"));

		assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
		assertEquals("La compra ya esta en el estado RECEIVED", response.getBody().getMessage());
	}

	@Test
	void returnsUnauthorizedStatusForUnauthorizedException() {
		var response = handler.handleApiException(new UnauthorizedException("Credenciales invalidas"));

		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
		assertEquals("Credenciales invalidas", response.getBody().getMessage());
	}

	@Test
	void returnsInternalServerErrorForUnexpectedException() {
		var response = handler.handleUnexpected(new RuntimeException("boom"));

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		assertEquals(ErrorMessages.INTERNAL_SERVER_ERROR, response.getBody().getMessage());
	}
}
