package com.bigobooks.shared.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.bigobooks.shared.exception.ApiException;

class CommonExceptionHandlerTest {

	@Test
	void returnsSharedErrorDtoAndStatusForApiException() {
		var response = new CommonExceptionHandler()
				.handleApiException(new ApiException(HttpStatus.NOT_FOUND, "Recurso inexistente"));

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals("Recurso inexistente", response.getBody().getMessage());
	}
}
