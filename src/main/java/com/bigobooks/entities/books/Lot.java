package com.bigobooks.entities.books;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(indexes = @Index(columnList = "book_id"))
@Getter
@Setter
public class Lot extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false, unique = true)
    private Long purchaseDetailId;

    @Column(nullable = false)
    private long unitCost;

    @Column(nullable = false)
    private int marginApplied;

    @Column(nullable = false)
    private long salePrice;

    @Column(nullable = false)
    private int quantityReceived;

    @Column(nullable = false)
    private int quantityRemaining;
}
