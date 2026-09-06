package com.bigobooks.entities.rents;

import java.time.LocalDate;

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
public class RentDetail {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    private long price;

    private int monthsRented;

    private LocalDate returnDate;

    @ManyToOne()
    @JoinColumn(name = "rent_id")
    private Rent rent;

}
