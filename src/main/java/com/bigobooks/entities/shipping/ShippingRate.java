package com.bigobooks.entities.shipping;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

// Precio que una empresa de envio cobra por llevar a una ciudad.
//
// Es el tarifario que el cliente consulta ANTES de pagar, a diferencia de
// Shipment.shippingCost que recien se conoce cuando el courier informa.
//
// El precio es fijo: no depende del peso ni de la ciudad, siempre son un par de
// cajas. Asi que cada fila es (empresa, ciudad, precio) y la consulta del
// checkout es un findByShippingCompanyAndCity.
// El cliente nunca manda el monto, lo busca shipping.
@Entity
@Getter
@Setter
public class ShippingRate extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "shipping_company_id", nullable = false)
    private ShippingCompany shippingCompany; // Quien cobra este precio

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city; // Destino al que aplica este precio

    @Column(nullable = false)
    private Integer price; // Costo de enviar a esta ciudad
}
