package com.bigobooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.bigobooks.entities.BaseEntity;

/**
 * Contrato base de los repositorios. Las dos funciones de borrado logico son
 * opcionales: por defecto no devuelven filas borradas; un repositorio que
 * necesite verlas puede sobreescribirlas con una {@code @Query} nativa.
 */
@NoRepositoryBean
public interface IBaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

    default List<T> findDeleted() {
        return List.of();
    }

    default List<T> findAllIncludingDeleted() {
        return findAll();
    }
}
