package com.projetoequifax.domains.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "credit_card_transaction")
public class CreditCardTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transactionId;

    @Column(name = "credit_card", nullable = false)
    private String creditCard;

    public CreditCardTransaction(UUID transactionId, String creditCard) {
        this.transactionId = transactionId;
        this.creditCard = creditCard;
    }

    public CreditCardTransaction() {
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
