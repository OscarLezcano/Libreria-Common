package com.bigobooks.entities.books;

// import java.math.BigDecimal;
// import java.math.RoundingMode;
import java.util.List;

import com.bigobooks.entities.BaseEntity;

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
public class Book extends BaseEntity {

    private String CoverUrl;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int profitMargin;

    @ManyToMany
    @JoinTable(name = "book_genre", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @OneToMany(mappedBy = "book")
    private List<Wishlist> wishlists;

    @OneToMany(mappedBy = "book")
    private List<Lot> lots;

    // Esto deberia estar en un el servicio manito

    // public long salePriceFor(long unitCost) {
    // return BigDecimal.valueOf(unitCost)
    // .multiply(BigDecimal.valueOf(100L + profitMargin))
    // .divide(BigDecimal.valueOf(100), 0, RoundingMode.HALF_UP)
    // .longValue();
    // }

    // public Lot openLot(Long purchaseDetailId, long unitCost, int quantity) {
    // Lot lot = new Lot();
    // lot.setBook(this);
    // lot.setPurchaseDetailId(purchaseDetailId);
    // lot.setUnitCost(unitCost);
    // lot.setMarginApplied(profitMargin);
    // lot.setSalePrice(salePriceFor(unitCost));
    // lot.setQuantityReceived(quantity);
    // lot.setQuantityRemaining(quantity);
    // return lot;
    // }

}
