package com.projetoequifax.domains.service;

import com.projetoequifax.domains.repository.TransactionStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionStatusService {

    private final TransactionStatusRepository transactionStatusRepository;

    public TransactionStatusService(TransactionStatusRepository transactionStatusRepository) {
        this.transactionStatusRepository = transactionStatusRepository;
    }

    public BigDecimal getCCScoreByCreditCardCPF(String cpf) {
        return transactionStatusRepository.getCCScoreByCreditCardCPF(cpf);
    }

}
