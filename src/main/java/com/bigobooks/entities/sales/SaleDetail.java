package com.bigobooks.entities.sales;

import com.bigobooks.entities.BaseEntity;

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

    private long unitDiscount;

    @ManyToOne()
    @JoinColumn(name = "sales_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

}
