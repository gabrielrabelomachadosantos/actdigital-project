package com.projetoequifax.domains.dto;

import java.util.Objects;

public class CPFRatingResponseDTO {

    private String cpf;
    private String rating;

    public CPFRatingResponseDTO(String cpf, String rating) {
        this.cpf = cpf;
        this.rating = rating;
    }

    public CPFRatingResponseDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPFRatingResponseDTO that = (CPFRatingResponseDTO) o;
        return Objects.equals(cpf, that.cpf) && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, rating);
    }
}
