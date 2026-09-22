package com.bigobooks.entities.sales;

import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sale extends BaseEntity {

    private Long userId;
    @Enumerated(EnumType.STRING)
    private SalesStatus status = SalesStatus.PENDING;

    private int subTotal;
    private int discountAmountl;
    private int totalPrice;
    @Column(nullable = true)
    private int shippingFee;

    @OneToMany(mappedBy = "sale")
    private List<SaleDetail> saleDetails;
}
