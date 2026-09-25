package com.bigobooks.entities.orders;

import com.bigobooks.entities.BaseEntity;

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

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order order;
}