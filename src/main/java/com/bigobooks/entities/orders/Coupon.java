package com.bigobooks.entities.orders;

import java.time.LocalDateTime;
import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Coupon extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String code;

    private int discountPercent;

    private LocalDateTime validUntil;

    @OneToMany(mappedBy = "coupon")
    private List<Order> orders;
}
