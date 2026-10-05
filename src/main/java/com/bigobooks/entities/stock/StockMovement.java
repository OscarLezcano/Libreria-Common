package com.bigobooks.entities.stock;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StockMovement extends BaseEntity {

    private Long bookId;

    private String bookName;

    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StockMovementType movementType;

    // Referencia al documento que origina el movimiento (id de compra u orden).
    @Column(nullable = true)
    private String referenceId;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;
}
