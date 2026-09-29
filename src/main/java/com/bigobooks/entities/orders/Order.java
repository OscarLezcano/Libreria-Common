package com.bigobooks.entities.orders;

import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    // TOTAL FINAL QUE PAGA EL CLIENTE.
    // subtotal - discountAmount + quotedShippingCost
    // Es un snapshot: se calcula una vez al confirmar el pedido y no se recalcula.

    private long totalPrice;

    // SUBTOTAL: solo libros, sin descuento y sin envio.
    // Suma de (quantity * unitPrice - discount) de cada OrderDetail.
    // Sirve para mostrar la linea "libros" del checkout y para cobrar IVA
    // (10% en Paraguay) sobre esta base.

    @Column(nullable = false)
    private long subtotal;

    // MONTO TOTAL DESCONTADO por la promotion, en guaranies.
    // 0 cuando el pedido no tiene promocion. Es el resultado de aplicar
    // promotion.discountPercent sobre el subtotal, guardado como monto y no
    // como porcentaje para que el historico siga siendo valido si despues
    // editan o desactivan la promo.

    @Column(nullable = false)
    private long discountAmount;

    // PRESUPUESTO DE ENVIO QUE EL CLIENTE VIO Y PAGO.
    // Snapshot congelado: si shipping sube el tarifario, este pedido no se
    // recalcula.
    // Es un int y no una FK a la tarifa justamente por esto, para que el historico
    // sea inmutable. A diferencia de Shipment.shippingCost, que sigue en null hasta
    // que el courier informe lo que realmente cobro.

    @Column(nullable = false)
    private int quotedShippingCost;

    // Es solo referencia
    // para auditoria, el precio que manda es el quotedShippingCost de arriba.

    private Long shippingRateId;

    @ManyToOne
    @JoinColumn(name = "promotion_id", nullable = true)
    private Promotion promotion;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}