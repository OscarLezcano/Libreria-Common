package com.bigobooks.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.repository.BaseRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter()
@RequiredArgsConstructor()
public abstract class BaseService<T extends BaseEntity> {

    private final BaseRepository<T> repository;

    @Transactional(readOnly = true)
    public List<T> findDeleted() {
        return repository.findDeleted();
    }

    @Transactional(readOnly = true)
    public List<T> findAllIncludingDeleted() {
        return repository.findAllIncludingDeleted();
    }
}
