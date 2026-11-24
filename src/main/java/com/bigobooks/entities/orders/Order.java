package com.bigobooks.entities.orders;

import java.util.List;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.auth.UserAccount;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity {

    @Column(nullable = false, unique = true, updatable = false, length = 40)
    private String orderNumber;

    Long warehouseId;

    // Usuario que realizo la venta (cliente).
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    // Identificador publico de 8 digitos. Se genera en el servicio antes de
    // guardar para poder verificar colisiones con existsByNumeroOrden.
    @Column(name = "numero_orden", nullable = false, unique = true, updatable = false, length = 8)
    private String numeroOrden;

    // Idempotencia del checkout. El hash permite detectar reutilizacion de la
    // misma clave con un payload distinto.
    @Column(name = "idempotency_key", length = 255)
    private String idempotencyKey;

    @Column(name = "request_hash", length = 64)
    private String requestHash;

    // TOTAL FINAL QUE PAGA EL CLIENTE.
    // subtotal - discountAmount
    // Es un snapshot: se calcula una vez al confirmar el pedido y no se recalcula.

    private long totalPrice;

    // SUBTOTAL: solo libros, sin descuento.
    // Suma de (quantity * unitPrice - discount) de cada OrderDetail.
    // Sirve para mostrar la linea "libros" del checkout y para cobrar IVA
    // (10% en Paraguay) sobre esta base.

    @Column(nullable = false)
    private long subtotal;

    // MONTO TOTAL DESCONTADO por la coupon, en guaranies.
    // 0 cuando el pedido no tiene promocion. Es el resultado de aplicar
    // coupon.discountPercent sobre el subtotal, guardado como monto y no
    // como porcentaje para que el historico siga siendo valido si despues
    // editan o desactivan la promo.

    @Column(nullable = false)
    private long discountAmount;

    // Codigo legible snapshot de la coupon aplicada; la entidad Coupon puede
    // cambiar o desactivarse sin alterar el historial del pedido.
    @Column(name = "coupon_code", length = 100)
    private String couponCode;

    // Datos fake para simular bancard (legacy, no se expone en el contrato).
    private String bancardNumber;

    // Datos fiscales del comprador, separados del destinatario.
    private String invoiceNumber;
    private String invoiceRuc;
    private String invoiceName;
    private String invoiceLastName;
    private String invoicePhone;

    // Snapshot plano del destinatario, separado de la facturacion.
    @Column(name = "shipping_name")
    private String shippingName;

    @Column(name = "shipping_last_name")
    private String shippingLastName;

    @Column(name = "shipping_department")
    private String shippingDepartment;

    @Column(name = "shipping_city")
    private String shippingCity;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "shipping_reference")
    private String shippingReference;

    @Column(name = "shipping_phone")
    private String shippingPhone;

    @ManyToOne
    @JoinColumn(name = "coupon_id", nullable = true)
    private Coupon coupon;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @PrePersist
    private void assignOrderNumber() {
        if (orderNumber == null || orderNumber.isBlank()) {
            orderNumber = "PED-" + java.util.UUID.randomUUID().toString().toUpperCase();
        }
    }
}
