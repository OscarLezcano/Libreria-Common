package com.bigobooks.entities.sales;

import java.util.List;

import com.bigobooks.entities.BaseCoupon;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SaleCouponTemplate extends BaseCoupon {

    @OneToMany(mappedBy = "coupon")
    private List<SaleCoupon> coupons;
}