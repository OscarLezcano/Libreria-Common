package com.bigobooks.entities.auth;

import java.util.List;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.sales.Sale;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserAccount extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "userAccount")
    private List<Sale> sales;

    @OneToMany(mappedBy = "userAccount")
    private List<WishlistItem> wishlistItems;
}