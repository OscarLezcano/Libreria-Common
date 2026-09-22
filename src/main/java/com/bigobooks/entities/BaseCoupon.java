package com.bigobooks.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseCoupon extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String code;

    private int discountPercentage;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer maxUses;

    private Long maxDiscountAmount;
}