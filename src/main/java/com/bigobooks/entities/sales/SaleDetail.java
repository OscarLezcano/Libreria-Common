package com.bigobooks.entities.sales;

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
public class SaleDetail extends BaseEntity {

    private Long bookId;

    private int quantity;

    private long unitPrice;

    private long discountAmount;

    @Column(nullable = false)
    private String bookTitle;

    @ManyToOne()
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

}
