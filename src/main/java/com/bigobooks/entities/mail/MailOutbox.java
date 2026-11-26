package com.bigobooks.entities.mail;

import java.time.LocalDateTime;

import com.bigobooks.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Correo pendiente de envio. El proceso programado envia cada registro una
 * sola vez y cambia {@code pending} a false despues de un envio exitoso.
 */
@Entity
@Table(name = "mail_outbox")
@Getter
@Setter
public class MailOutbox extends BaseEntity {

    @Column(nullable = false)
    private String recipient;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @Column(nullable = false, length = 40)
    private String type = "GENERIC";

    @Column(nullable = false)
    private boolean pending = true;

    private LocalDateTime sentAt;
}
