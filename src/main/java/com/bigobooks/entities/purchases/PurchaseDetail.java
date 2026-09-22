package com.bigobooks.entities.purchases;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PurchaseDetail extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    private int quantity;

    private long unitCost;

    private long subtotal;

    @Enumerated(EnumType.STRING)
    private PurchaseEnum status;
}
