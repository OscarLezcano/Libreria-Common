package com.bigobooks.entities.sales;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "promotion_id", "book_id" }), indexes = @Index(columnList = "book_id"))
@Getter
@Setter
public class PromotionBook extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "promotion_id", nullable = false)
    private Promotion promotion;

    @Column(name = "book_id", nullable = false)
    private Long bookId;
}