package com.bigobooks.entities.shipping;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShipmentDetail extends BaseEntity {

    private Long bookId;

    private String bookName;

    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;
}