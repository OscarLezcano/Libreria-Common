package com.bigobooks.entities.shipping;

public enum ShipmentStatus {
    // El envío está siendo preparado en el almacén antes de salir
    PROCESSING,
    // Solo parte del pedido fue despachada, faltan libros por enviar
    PARTIALLY_SHIPPED,
    // El paquete salió y está en manos de la empresa de transporte
    SHIPPED,
    // El paquete fue entregado al cliente
    DELIVERED,
    // La entrega falló (dirección incorrecta, cliente ausente, etc.)
    FAILED
}