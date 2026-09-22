package com.bigobooks.entities.book;

import java.util.List;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.auth.WishlistItem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(nullable = false)
    private int stock;

    @OneToMany(mappedBy = "book")
    private List<BookGenre> bookGenres;

    @OneToMany(mappedBy = "book")
    private List<BookAuthor> bookAuthors;

    @OneToMany(mappedBy = "book")
    private List<WishlistItem> wishlistItems;

    @OneToMany(mappedBy = "book")
    private List<BookPromotion> bookPromotions;
}