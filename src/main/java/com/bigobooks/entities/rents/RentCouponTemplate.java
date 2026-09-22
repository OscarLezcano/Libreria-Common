package com.bigobooks.entities.rents;

import java.util.List;

import com.bigobooks.entities.BaseCoupon;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RentCouponTemplate extends BaseCoupon {

    @OneToMany(mappedBy = "coupon")
    private List<RentCoupon> coupons;
}