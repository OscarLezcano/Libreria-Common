package com.bigobooks.util.exception;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.bigobooks.dto.ErrorDto;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class CommonExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(CommonExceptionHandler.class);

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorDto> handleApiException(ApiException ex) {
		return build(ex.getStatus(), ex.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDto> handleValidation(MethodArgumentNotValidException ex) {
		String message = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage())
				.collect(Collectors.joining(", "));
		return build(HttpStatus.BAD_REQUEST, message.isBlank() ? "Error de validacion" : message);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDto> handleConstraintViolation(ConstraintViolationException ex) {
		return build(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDto> handleIllegalArgument(IllegalArgumentException ex) {
		return build(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorDto> handleUnreadableRequest(HttpMessageNotReadableException ex) {
		return build(HttpStatus.BAD_REQUEST, "Cuerpo de la peticion invalido");
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorDto> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
		return build(HttpStatus.BAD_REQUEST, "Parametro invalido: " + ex.getName());
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<ErrorDto> handleNoResource(NoResourceFoundException ex) {
		return build(HttpStatus.NOT_FOUND, "Recurso no encontrado");
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDto> handleDataIntegrity(DataIntegrityViolationException ex) {
		return build(HttpStatus.CONFLICT, "Conflicto de integridad con los datos");
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorDto> handleAccessDenied(AccessDeniedException ex) {
		return build(HttpStatus.FORBIDDEN, "No posees permisos para acceder a este recurso");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDto> handleUnexpected(Exception ex) {
		log.error("Error no controlado", ex);
		return build(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
	}

	private ResponseEntity<ErrorDto> build(HttpStatus status, String message) {
		return ResponseEntity.status(status).body(new ErrorDto().message(message));
	}
}
