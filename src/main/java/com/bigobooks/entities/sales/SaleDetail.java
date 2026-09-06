package com.bigobooks.entities.sales;

import com.bigobooks.entities.book.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SaleDetail {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;

    private long price;

    @ManyToOne()
    @JoinColumn(name = "sales_id")
    private Sale sale;

}
