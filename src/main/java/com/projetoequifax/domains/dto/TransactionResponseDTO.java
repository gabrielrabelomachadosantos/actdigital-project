package com.projetoequifax.domains.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionResponseDTO {

    private BigDecimal totalAmount;
    private BigDecimal cpfRating;
    private BigDecimal ccScore;

    public TransactionResponseDTO(BigDecimal totalAmount, BigDecimal cpfRating, BigDecimal ccScore) {
        this.totalAmount = totalAmount;
        this.cpfRating = cpfRating;
        this.ccScore = ccScore;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getCpfRating() {
        return cpfRating;
    }

    public void setCpfRating(BigDecimal cpfRating) {
        this.cpfRating = cpfRating;
    }

    public BigDecimal getCcScore() {
        return ccScore;
    }

    public void setCcScore(BigDecimal ccScore) {
        this.ccScore = ccScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionResponseDTO that = (TransactionResponseDTO) o;
        return Objects.equals(totalAmount, that.totalAmount) && Objects.equals(cpfRating, that.cpfRating) && Objects.equals(ccScore, that.ccScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalAmount, cpfRating, ccScore);
    }
}
