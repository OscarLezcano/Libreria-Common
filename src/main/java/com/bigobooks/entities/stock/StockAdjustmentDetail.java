package com.bigobooks.entities.stock;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.book.Book;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stock_adjustment_details")
@Getter
@Setter
public class StockAdjustmentDetail extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "stock_adjustment_id")
    private StockAdjustment stockAdjustment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private int systemQuantity; // Cantidad que registraba el sistema antes de ajustar

    @Column(nullable = false)
    private int physicalQuantity; // Cantidad real que se contó físicamente

}