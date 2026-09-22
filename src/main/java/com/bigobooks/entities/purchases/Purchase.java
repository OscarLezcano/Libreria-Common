package com.bigobooks.entities.purchases;

import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Purchase extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = true)
    private Supplier supplier;

    private int totalPrice;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseDetail> purchaseDetails;
}
