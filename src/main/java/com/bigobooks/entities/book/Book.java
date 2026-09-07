package com.bigobooks.entities.book;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import com.bigobooks.entities.auth.UserAccount;
import com.bigobooks.entities.promotions.Promotion;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String CoverUrl;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(name = "book_genre", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @ManyToMany(mappedBy = "wishlist")
    private List<UserAccount> wishlistedBy;

    @ManyToMany(mappedBy = "books")
    private List<Promotion> promotions;
}