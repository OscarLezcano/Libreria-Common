package com.bigobooks.entities.purchases;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PurchaseDetail extends BaseEntity {

    private Long bookId;

    private String bookName;

    private int quantity;

    private long unitCost;

    @ManyToOne()
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
}
