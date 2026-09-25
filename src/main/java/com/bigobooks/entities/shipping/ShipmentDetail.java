package com.bigobooks.entities.shipping;

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
public class ShipmentDetail extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;
}