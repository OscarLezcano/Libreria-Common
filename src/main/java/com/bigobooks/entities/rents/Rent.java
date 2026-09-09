package com.bigobooks.entities.rents;

import java.util.List;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.auth.UserAccount;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rent extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
    // private SalesStatus status; // Deber ser un enum, lo hare mas tarde

    private int totalPrice;

    @OneToMany(mappedBy = "rent")
    private List<RentDetail> rentDetails;
}
