package com.bigobooks.entities.sales;

import java.time.LocalDateTime;
import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "promotions")
@Getter
@Setter
public class Promotion extends BaseEntity {
    private String title;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    private int discountPercentage;

    private int currentUsageCount;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PromotionBook> eligibleBooks;

    @OneToMany(mappedBy = "promotion")
    private List<SaleDetail> saleDetails;
}
