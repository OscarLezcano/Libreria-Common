package com.bigobooks.entities.purchases;

import java.time.LocalDateTime;

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
public class PurchaseDetail extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    /** Id del libro en books. No es FK: books es otro servicio. */
    @Column(name = "book_id", nullable = false)
    private Long bookId;

    /** Cantidad pedida al proveedor. No es la que entra a stock. */
    private int quantity;

    private long unitCost;

    /** quantity * unitCost. Lo pedido, no lo recibido. */
    private long subtotal;

    /**
     * Unidades que realmente llegaron. Puede ser menor que quantity.
     * En cero hasta la primera recepción.
     */
    @Column(nullable = false)
    private int receivedQuantity = 0;

    /** Última recepción de esta línea. Null hasta que llega algo. */
    private LocalDateTime receivedAt;

    /**
     * PENDING mientras se recibe. RECEIVED cierra la línea, aunque haya llegado
     * menos de lo pedido, y es el evento que abre el Lot en books.
     */
    @Enumerated(EnumType.STRING)
    private PurchaseEnum status;
}
