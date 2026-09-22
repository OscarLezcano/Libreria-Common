package com.bigobooks.entities.purchases;

public enum PurchaseEnum {
    /** Pedido al proveedor. Todavía no entró mercadería. */
    PENDING,
    /**
     * Recepción cerrada de esta línea. Ese cambio es el evento que abre el Lot
     * en books, usando el id del detalle como purchaseDetailId y receivedQuantity
     * como cantidad del lote. No usa la cantidad pedida: puede haber llegado menos.
     */
    RECEIVED,
    /** Anulada. No abre lote y no suma stock. */
    CANCELLED
}
