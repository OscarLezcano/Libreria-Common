package com.bigobooks.entities.orders;

import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    private int totalPrice;

    @ManyToOne
    @JoinColumn(name = "promotion_id", nullable = true)
    private Promotion promotion;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}