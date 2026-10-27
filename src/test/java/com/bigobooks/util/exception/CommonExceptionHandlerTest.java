package com.bigobooks.util.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class CommonExceptionHandlerTest {

	@Test
	void returnsSharedErrorDtoAndStatusForApiException() {
		var response = new CommonExceptionHandler()
				.handleApiException(new ApiException(HttpStatus.NOT_FOUND, "Recurso inexistente"));

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals("Recurso inexistente", response.getBody().getMessage());
	}
}
