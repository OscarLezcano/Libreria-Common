package com.bigobooks.repository;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.engine.spi.SessionFactoryImplementor;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import org.springframework.transaction.annotation.Transactional;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.EntityManager;

public class BaseRepositoryImpl<T extends BaseEntity> extends SimpleJpaRepository<T, Long>
        implements BaseRepository<T> {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findDeleted() {
        return nativeQuery("SELECT * FROM " + tableName() + " WHERE is_deleted = true");
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAllIncludingDeleted() {
        return nativeQuery("SELECT * FROM " + tableName());
    }

    private List<T> nativeQuery(String sql) {
        return entityManager.unwrap(Session.class)
                .createNativeQuery(sql, getDomainClass())
                .getResultList();
    }

    private String tableName() {
        return entityManager.getEntityManagerFactory()
                .unwrap(SessionFactoryImplementor.class)
                .getMappingMetamodel()
                .getEntityDescriptor(getDomainClass())
                .getTableName();
    }

}