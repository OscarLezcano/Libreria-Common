package com.bigobooks.entities.sales;

import com.bigobooks.entities.BaseAppliedCoupon;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SaleCoupon extends BaseAppliedCoupon {

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "coupon_template_id")
    private SaleCouponTemplate coupon;
}