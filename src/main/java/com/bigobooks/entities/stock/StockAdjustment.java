package com.bigobooks.entities.stock;

import java.util.ArrayList;
import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stock_adjustments")
@Getter
@Setter
public class StockAdjustment extends BaseEntity {

    @Column(nullable = false)
    private String note; // Motivo u observación del ajuste (ej: "Conteo físico trimestral")

    @ManyToOne()
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse; // Depósito donde se realiza la corrección

    @OneToMany(mappedBy = "stockAdjustment")
    private List<StockAdjustmentDetail> details = new ArrayList<>();

}