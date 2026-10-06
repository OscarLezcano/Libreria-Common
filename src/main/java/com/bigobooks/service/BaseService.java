package com.bigobooks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.repository.BaseRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseService<T extends BaseEntity, R extends BaseRepository<T>> {

    private final R repository;

    protected R getRepository() {
        return repository;
    }

    @Transactional(readOnly = true)
    protected List<T> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    protected Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    protected T save(T entity) {
        return repository.save(entity);
    }

    @Transactional
    protected void deleteById(Long id) {
        repository.deleteById(id);
    }
}
