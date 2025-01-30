package com.projetoequifax.domains.entity;

import com.projetoequifax.domains.enums.CPFRatingEnum;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cpf_rating")
public class CPFRating {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name= "cpf", nullable = false)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name= "rating", nullable = false)
    private CPFRatingEnum rating;

    public CPFRating(UUID id, String cpf, CPFRatingEnum rating) {
        this.id = id;
        this.cpf = cpf;
        this.rating = rating;
    }

    public CPFRating() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public CPFRatingEnum getRating() {
        return rating;
    }

    public void setRating(CPFRatingEnum rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPFRating cpfRating = (CPFRating) o;
        return Objects.equals(id, cpfRating.id) && Objects.equals(cpf, cpfRating.cpf) && rating == cpfRating.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, rating);
    }
}
