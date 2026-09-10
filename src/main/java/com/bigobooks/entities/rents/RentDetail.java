package com.bigobooks.entities.rents;

import java.time.LocalDate;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.book.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RentDetail extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    private long price;

    private int monthsRented;

    @Column(nullable = false)
    private LocalDate returnDate;

    @ManyToOne()
    @JoinColumn(name = "rent_id")
    private Rent rent;

    public boolean isActive() {
        return returnDate.isAfter(LocalDate.now());
    }
}
