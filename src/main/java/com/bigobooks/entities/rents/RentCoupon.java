package com.bigobooks.entities.rents;

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
public class RentCoupon extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "rent_id")
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "coupon_template_id")
    private RentCouponTemplate coupon;

    private int discountPercentage;

    private long discountAmount;

    @Column(nullable = false)
    private LocalDateTime appliedAt;
}