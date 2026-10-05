package com.bigobooks.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@SQLDelete(sql = "UPDATE #{#entityName} SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private boolean isDeleted = false;
}
