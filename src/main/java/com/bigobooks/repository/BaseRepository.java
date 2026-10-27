package com.bigobooks.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import com.bigobooks.entities.BaseEntity;

/**
 * Repositorio base con soft delete: los metodos {@code delete*} de JPA se
 * sobreescriben para marcar {@code is_deleted = true} en lugar de eliminar la
 * fila. Los {@code default} de la interfaz tienen precedencia sobre
 * {@code SimpleJpaRepository}.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends IBaseRepository<T> {

    @Override
    @Transactional
    default void delete(T entity) {
        entity.setDeleted(true);
        save(entity);
    }

    @Override
    @Transactional
    default void deleteById(Long id) {
        findById(id).ifPresent(this::delete);
    }

    @Override
    @Transactional
    default void deleteAll(Iterable<? extends T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    @Transactional
    default void deleteAll() {
        deleteAll(findAll());
    }

    @Override
    @Transactional
    default void deleteAllById(Iterable<? extends Long> ids) {
        ids.forEach(this::deleteById);
    }
}
