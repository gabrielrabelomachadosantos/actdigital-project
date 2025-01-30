package com.projetoequifax.domains.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionRequestDTO {

    private BigDecimal totalAmount;
    private String cpf;
    private CC cc;

    public TransactionRequestDTO(BigDecimal totalAmount, String cpf, CC cc) {
        this.totalAmount = totalAmount;
        this.cpf = cpf;
        this.cc = cc;
    }

    public TransactionRequestDTO() {
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionRequestDTO that = (TransactionRequestDTO) o;
        return Objects.equals(totalAmount, that.totalAmount) && Objects.equals(cpf, that.cpf) && Objects.equals(cc, that.cc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalAmount, cpf, cc);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public CC getCc() {
        return cc;
    }

    public void setCc(CC cc) {
        this.cc = cc;
    }

    private static class CC {

        private String bin;
        private String last4;

        public CC(String bin, String last4) {
            this.bin = bin;
            this.last4 = last4;
        }

        public CC() {
        }

        public String getBin() {
            return bin;
        }

        public void setBin(String bin) {
            this.bin = bin;
        }

        public String getLast4() {
            return last4;
        }

        public void setLast4(String last4) {
            this.last4 = last4;
        }
    }

}
