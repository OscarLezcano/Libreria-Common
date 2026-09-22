package com.bigobooks.entities.purchases;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.book.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PurchaseDetail extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;

    private long price;

    @ManyToOne()
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
}
