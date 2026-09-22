package com.bigobooks.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bigobooks.repositories.BaseRepository;

public abstract class BaseService<T, ID, R extends BaseRepository<T, ID>> {

    protected final R repository;

    protected BaseService(R repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T update(ID id, T entity) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entity not found with id: " + id);
        }
        return repository.save(entity);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

    public T getById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entity not found with id: " + id));
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public Page<T> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}