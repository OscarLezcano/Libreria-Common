package com.bigobooks.entities.stock;

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
public class Stock extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

}
