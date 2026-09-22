package com.bigobooks.entities.sales;

import java.util.List;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.auth.UserAccount;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sale extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private UserAccount userAccount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SalesStatus status = SalesStatus.PENDING;

    private int totalPrice;

    @OneToMany(mappedBy = "sale")
    private List<SaleDetail> saleDetails;

    @OneToMany(mappedBy = "sale")
    private List<SaleCoupon> saleCoupons;
}
