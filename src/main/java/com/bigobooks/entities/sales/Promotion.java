package com.bigobooks.entities.sales;

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
public class Promotion extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String title;

    private String code;

    private int discountPercentage;

    private int minimumPurchaseAmount;

    private int maxDiscountAmount;

    private Integer globalUsageLimit; // Límite total (ej: Primeros 100 usuarios)

    private Integer currentUsageCount = 0; // Contador de usos acumulados

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "promotion")
    private List<SaleDetail> saleDetails;
}
