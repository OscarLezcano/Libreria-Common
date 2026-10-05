package com.bigobooks.entities.stock;

public enum StockMovementType {
    // Entrada de mercancía por compra a proveedor
    PURCHASE,
    // Salida de mercancía por venta
    SALE,
    // Corrección manual del inventario (merma, rotura, conteo físico)
    ADJUSTMENT
}
