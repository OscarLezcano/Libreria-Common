package com.bigobooks.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Respuesta de paginación genérica.
 *
 * <p>
 * Vive en la librería compartida {@code bigobooks} para que todos los
 * microservicios reutilicen el mismo contrato de paginación sin duplicar DTOs.
 *
 * @param <T> tipo de los elementos de la página
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDto<T> {

    /** Elementos de la página actual. */
    private List<T> content;

    /** Número de página (empieza en 0). */
    private int page;

    /** Tamaño de la página. */
    private int size;

    /** Total de elementos (todas las páginas). */
    private long totalElements;

    /** Total de páginas. */
    private int totalPages;

    /**
     * Factory a partir de un {@link Page} de Spring Data.
     *
     * @param <T>     tipo de los elementos de salida
     * @param page    página fuente (los metadatos de paginación)
     * @param content elementos ya mapeados al DTO de salida
     * @return DTO de paginación listo para serializar
     */
    public static <T> PageResponseDto<T> from(Page<?> page, List<T> content) {
        return new PageResponseDto<>(
                content,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages());
    }
}