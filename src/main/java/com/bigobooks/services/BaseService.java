package com.bigobooks.services;

import java.util.List;
import java.util.Optional;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.repositories.BaseRepository;

public abstract class BaseService<T extends BaseEntity> {

    protected final BaseRepository<T, Long> repository;

    protected BaseService(BaseRepository<T, Long> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
