package com.bigobooks.entities.stock;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stock extends BaseEntity {

    private Long bookId;

    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

}
