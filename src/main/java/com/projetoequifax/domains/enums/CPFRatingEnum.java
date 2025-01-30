package com.projetoequifax.domains.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

public enum CPFRatingEnum {

    GOOD(BigDecimal.valueOf(0.0)),
    BAD(BigDecimal.valueOf(1.0)),
    UNKNOWN(null);

    private final BigDecimal rating;

    CPFRatingEnum(BigDecimal rating) {
        this.rating = rating;
    }

    public static BigDecimal getRatingByName(String name) {
        return switch (name.toUpperCase()) {
            case "GOOD" -> GOOD.rating;
            case "BAD" -> BAD.rating;
            default -> UNKNOWN.rating;
        };
    }

    public BigDecimal getRating() {
        return rating;
    }
}
