package com.bigobooks.entities.purchases;

import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Supplier extends BaseEntity {

    @Column(nullable = false)
    private String name;

    /**
     * RUC (Registro Único de Contribuyentes), el identificador fiscal en Paraguay.
     * Con dígito verificador. Ej: 80012345-6
     */
    @Column(nullable = false, unique = true, length = 12)
    private String ruc;

    /** Teléfono local. Ej: 0981123456 o 021123456 */
    private String phone;

    @Column(unique = true)
    private String email;

    private String address;

    @OneToMany(mappedBy = "supplier")
    private List<Purchase> purchases;
}
