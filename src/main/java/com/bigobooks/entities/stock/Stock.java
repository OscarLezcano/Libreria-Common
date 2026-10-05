package com.bigobooks.entities.stock;

import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stock extends BaseEntity {

    private int quantity;

    private int minStock;

    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = true)
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @OneToMany(mappedBy = "stock")
    private List<StockMovement> movements;
}
