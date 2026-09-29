package com.bigobooks.entities.shipping;

import java.util.List;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

// Departamento del Paraguay. Es la parte alta de la jerarquia de destinos:
// de aqui cuelgan las ciudades a las que se envia.
@Entity
@Getter
@Setter
public class Department extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name; // Ej: Central

    @OneToMany(mappedBy = "department")
    private List<City> cities;
}
