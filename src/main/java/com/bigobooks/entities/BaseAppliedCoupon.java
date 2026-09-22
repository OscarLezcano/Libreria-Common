package com.bigobooks.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseAppliedCoupon extends BaseEntity {

    private int discountPercentage;

    private long discountAmount;

    @Column(nullable = false)
    private LocalDateTime appliedAt;
}