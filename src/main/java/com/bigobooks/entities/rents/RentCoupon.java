package com.bigobooks.entities.rents;

import com.bigobooks.entities.BaseAppliedCoupon;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RentCoupon extends BaseAppliedCoupon {

    @ManyToOne
    @JoinColumn(name = "rent_id")
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "coupon_template_id")
    private RentCouponTemplate coupon;
}