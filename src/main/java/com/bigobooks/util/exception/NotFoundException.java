package com.bigobooks.util.exception;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {

	private NotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}

	public static NotFoundException byId(ResourceType resource, Object id) {
		return byAttributes(resource, Map.of(ResourceType.ID, id));
	}

	public static NotFoundException byCode(ResourceType resource, Object code) {
		return byAttributes(resource, Map.of(ResourceType.CODE, code));
	}

	public static NotFoundException byAttributes(ResourceType resource, Map<ResourceType, ?> attributes) {
		String details = attributes.entrySet().stream()
				.sorted(Comparator.comparingInt(entry -> entry.getKey().ordinal()))
				.map(entry -> entry.getKey().label() + " " + entry.getValue())
				.collect(Collectors.joining(" y "));
		return new NotFoundException("No se encontró " + resource.label() + " con " + details);
	}

	public static NotFoundException notAssociated(ResourceType resource, Object id, ResourceType related,
			Object relatedId) {
		return new NotFoundException("No se encontró " + resource.label() + " con id " + id
				+ " asociado a " + related.label() + " con id " + relatedId);
	}
}
