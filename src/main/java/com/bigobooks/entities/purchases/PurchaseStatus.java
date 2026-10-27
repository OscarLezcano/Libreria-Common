package com.bigobooks.entities.purchases;

public enum PurchaseStatus {
    // Compra hecha al proveedor, esperando que llegue la mercancía
    PENDING,
    // La mercancía llegó y se registró en el inventario
    RECEIVED,
    // La compra fue cancelada
    CANCELLED
}