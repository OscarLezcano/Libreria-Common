package com.bigobooks.entities.books;

import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book extends BaseEntity {

    private String CoverUrl;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    private int stock;

    @ManyToMany
    @JoinTable(name = "book_genre", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @OneToMany(mappedBy = "book")
    private List<Wishlist> wishlists;

}
