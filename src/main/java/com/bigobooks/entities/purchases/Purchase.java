package com.bigobooks.entities.purchases;

import java.util.List;

import com.bigobooks.entities.BaseEntity;

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
public class Purchase extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    /**
     * Estado del pedido completo. El Lot no se abre acá: se abre por cada
     * PurchaseDetail que pasa a RECEIVED, porque books identifica el lote
     * con purchaseDetailId.
     */
    @Enumerated(EnumType.STRING)
    private PurchaseEnum status;

    private long totalPrice;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseDetail> purchaseDetails;
}
