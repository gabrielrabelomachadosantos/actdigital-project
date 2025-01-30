package com.projetoequifax.domains.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

public enum TransactionStatusEnum {

    APPROVED(BigDecimal.valueOf(-1.0)),
    PENDING(BigDecimal.valueOf(0.0)),
    DECLINED(BigDecimal.valueOf(5.0));

    private final BigDecimal score;

    TransactionStatusEnum(BigDecimal score) {
        this.score = score;
    }

    public BigDecimal getScore() {
        return score;
    }
}
