package com.bigobooks.entities.shipping;

import java.math.BigInteger;
import java.time.LocalDateTime;
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
public class Shipment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "shipping_company_id", nullable = true)
    private ShippingCompany shippingCompany; // Id del a companhia

    private Long orderId; // Id del pedido

    private Long approvedById; // El id del usuario que aprobo esto

    // DATOS DEL CLIENTE QUE PIDIO EL PRODUCTO REGISTRADO EN EL SISTEMA

    private Long customerId; // EL id del usuario cliente que pidio el producto

    private String customerName; // Nombre del cliente que pidio esto

    private String customerDocument; // Documento del cliente

    private String customePhone; // Numero de telefono del personaje que recibira el paquete

    // DATOS DE LA PERSONA QUE RECIVIO (PUEDE SER EL MISMO CLIENTE COMO PUEDE SER
    // OTRA PERSONA) son null hasta que el status pase a DELIVERED

    private String recipientName;
    private String recipientDocument;

    // DATOS DE DIRECCION

    private String department;

    private String city;

    private String referencePoint; // Por ejemplo: En una casa de porton verde

    // AQUI OTROS DATOS VARIOS

    private String trackingNumber; // Numero de traqueo dado por la companhia

    @Column(nullable = false)
    private BigInteger shippingCost; // Costo del envio

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShipmentStatus status;

    // shippedAt (Fecha de despacho): Marca el momento exacto en que el paquete sale
    // de tu librería y pasa a manos de la empresa de transporte.

    // Cambio de estado: El envío pasa de PROCESSING a SHIPPED

    private LocalDateTime shippedAt;

    private LocalDateTime deliveredAt; // Tiempo en el que fue entregado

    // Si la entrega falla se registra en esta tabla una nota de porque fallo
    private String failureReason; // Ej: direccion incorrecta, cliente asuente, etc

    @OneToMany(mappedBy = "shipment")
    private List<ShipmentDetail> shipmentDetails;
}