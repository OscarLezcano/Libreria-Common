package com.bigobooks.entities.orders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bigobooks.entities.BaseEntity;
import com.bigobooks.entities.book.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Coupon extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String code;

    private int discountPercent;

    private LocalDateTime validFrom;

    private LocalDateTime validUntil;

    /**
     * Si es true, cada usuario puede canjear el cupon una sola vez. Apagado
     * por defecto para no cambiar el comportamiento de los cupones existentes.
     */
    private boolean singleUsePerUser = false;

    /**
     * Libros incluidos en el descuento. Una coleccion vacia mantiene el
     * comportamiento historico: el cupon se aplica a todo el pedido.
     */
    @ManyToMany
    @JoinTable(
        name = "coupon_book",
        joinColumns = @JoinColumn(name = "coupon_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "coupon")
    private List<Order> orders;
}
