package com.bigobooks.entities.promotions;

import java.time.LocalDateTime;
import java.util.List;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.book.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Promotion extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String title;

    private String description;

    private int discount;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @ManyToMany
    @JoinTable(name = "book_promotion", joinColumns = @JoinColumn(name = "promotion_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;
}