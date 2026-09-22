package com.bigobooks.entities.books;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookCollectionDetail extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "collection_id")
    private BookCollection collection;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private int position;

    private String note;

    private int priority;
}
