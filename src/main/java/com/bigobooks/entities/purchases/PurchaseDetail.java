package com.bigobooks.entities.purchases;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.books.Book;

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

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;

    private long unitPrice;

    private long subtotal;

    @Enumerated(EnumType.STRING)
    private PurchaseEnum status;
}
