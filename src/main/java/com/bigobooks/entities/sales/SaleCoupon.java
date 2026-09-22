package com.bigobooks.entities.sales;

import java.time.LocalDateTime;

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
public class SaleCoupon extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "coupon_template_id")
    private SaleCouponTemplate coupon;

    private int discountPercentage;

    private long discountAmount;

    @Column(nullable = false)
    private LocalDateTime appliedAt;
}