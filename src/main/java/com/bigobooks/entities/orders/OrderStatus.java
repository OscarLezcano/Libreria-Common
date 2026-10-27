package com.bigobooks.entities.orders;

public enum OrderStatus {
    // Pedido creado, esperando confirmación del pago bancario
    PENDING,
    // El pago bancario fue confirmado
    PAID,
    // El dinero del pedido fue devuelto al cliente
    REFUNDED,
    // El pedido fue cancelado (antes del despacho o pago)
    CANCELLED,
}