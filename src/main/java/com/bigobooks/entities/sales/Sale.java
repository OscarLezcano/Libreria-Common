package com.bigobooks.entities.sales;

import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(indexes = @Index(columnList = "user_id"))
@Getter
@Setter
public class Sale extends BaseEntity {

    @Column(name = "user_id")
    private Long userId;
    @Enumerated(EnumType.STRING)
    private SalesStatus status = SalesStatus.PENDING;

    private long subTotal;
    private long totalDiscount;
    private long totalPrice;
    @Column(nullable = true)
    private Long shippingFee;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleDetail> saleDetails;
}
