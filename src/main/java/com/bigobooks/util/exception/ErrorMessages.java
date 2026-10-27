package com.bigobooks.util.exception;

public final class ErrorMessages {

	// Error 500: cualquier excepción no controlada (NullPointerException, fallo inesperado de BD, etc.).
	public static final String INTERNAL_SERVER_ERROR = "Error interno del servidor";

	// Error 400 de respaldo: @Valid o ConstraintViolation sin errores de campo que mostrar.
	public static final String VALIDATION_ERROR = "Error de validación";

	// Error 400: JSON malformado, tipo incorrecto o body faltante (HttpMessageNotReadableException).
	public static final String INVALID_REQUEST_BODY = "Cuerpo de la petición inválido";

	// Error 400: path/query con tipo incorrecto (MethodArgumentTypeMismatchException). Se concatena el nombre del parámetro.
	public static final String INVALID_PARAMETER_PREFIX = "Parámetro inválido: ";

	// Error 400: falta un @RequestParam obligatorio (MissingServletRequestParameterException). Se concatena el nombre.
	public static final String MISSING_PARAMETER_PREFIX = "Parámetro requerido: ";

	// Error 405: método HTTP no soportado por el endpoint (HttpRequestMethodNotSupportedException).
	public static final String METHOD_NOT_ALLOWED = "Método HTTP no permitido";

	// Error 415: Content-Type no soportado (HttpMediaTypeNotSupportedException).
	public static final String UNSUPPORTED_MEDIA_TYPE = "Tipo de contenido no soportado";

	// Error 404: ruta o recurso estático inexistente (NoResourceFoundException). Los 404 de negocio usan NotFoundException.
	public static final String RESOURCE_NOT_FOUND = "Recurso no encontrado";

	// Error 409: violación de constraint de BD (DataIntegrityViolationException), ej. duplicados o FK inválida.
	public static final String DATA_CONFLICT = "Conflicto de integridad con los datos";

	// Error 403: @PreAuthorize rechaza por falta de rol (AccessDeniedException). El 401/403 del filtro usa el default de Spring.
	public static final String ACCESS_DENIED = "No posee los permisos necesarios para realizar esta operación";

	private ErrorMessages() {
	}
}
