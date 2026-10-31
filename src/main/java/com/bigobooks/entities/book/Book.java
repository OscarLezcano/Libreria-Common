package com.bigobooks.entities.book;

import java.util.List;

import com.bigobooks.entities.BaseEntity;
import jakarta.persistence.CascadeType;
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

    // Precio de venta en guaranies. Null si el libro todavia no tiene precio.
    private Long price;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookGenre> genres;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookAuthor> authors;
}
