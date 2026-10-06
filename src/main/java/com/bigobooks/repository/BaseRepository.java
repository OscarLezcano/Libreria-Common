package com.bigobooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.bigobooks.entities.BaseEntity;

/**
 * Repositorio base de todas las entidades con borrado logico
 * (ver {@link com.bigobooks.entities.BaseEntity}).
 *
 * Nota: no declara findDeleted()/findAllIncludingDeleted(): esas queries
 * derivadas no resuelven ninguna propiedad y, ademas, {@code @SQLRestriction}
 * de BaseEntity impide leer filas con is_deleted = true desde JPQL.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
