package com.bigobooks.entities.orders;

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
public class OrderDetail extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;

    private long price;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order order;
}