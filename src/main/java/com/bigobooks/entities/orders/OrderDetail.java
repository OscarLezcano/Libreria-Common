package com.bigobooks.entities.orders;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderDetail extends BaseEntity {

    private Long bookId;

    private String bookName;

    private int quantity;

    private long unitPrice;

    private long discount;

    // Snapshot del catalogo al momento de la compra. El detalle no depende de
    // cambios posteriores de portada ni de autores en el catalogo.
    @Column(name = "cover_src")
    private String coverSrc;

    // Nombres de autores separados por ", ". Se convierte a List<String> en el DTO.
    @Column(name = "authors")
    private String authors;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order order;
}