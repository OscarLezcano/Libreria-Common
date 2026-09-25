package com.bigobooks.entities.shipping;

import java.util.List;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.orders.Order;

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
public class Shipment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "shipping_company_id", nullable = true)
    private ShippingCompany shippingCompany;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShipmentStatus status;

    @OneToMany(mappedBy = "shipment")
    private List<ShipmentDetail> shipmentDetails;
}