package com.bigobooks.entities.shipping;

import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

// Ciudad del Paraguay a la que se envia.
@Entity
@Getter
@Setter
public class City extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name; // Ej: Luque

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department; // Ciudad unica, Ej: Central

    // El precio que una empresa cobra por esta ciudad se busca en ShippingRate,
    // filtrando por esta ciudad y por la empresa.

    @OneToMany(mappedBy = "city")
    private List<ShippingRate> shippingRates;
}
