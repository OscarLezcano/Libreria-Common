package com.bigobooks.entities.orders;

public enum PromotionStatus {
    // La promoción está vigente y aplicable a nuevos pedidos
    ACTIVE,
    // La promoción venció (su validUntil pasó)
    EXPIRED,
    // La promoción fue desactivada manualmente
    DISABLED
}