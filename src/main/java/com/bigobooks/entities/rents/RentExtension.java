package com.bigobooks.entities.rents;

import java.time.LocalDate;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RentExtension extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "rent_detail_id")
    private RentDetail rentDetail;

    private int monthsExtended;

    private long extraPrice;

    @Column(nullable = false)
    private LocalDate newReturnDate;
}