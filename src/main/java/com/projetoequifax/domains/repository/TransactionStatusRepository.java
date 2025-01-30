package com.projetoequifax.domains.repository;

import com.projetoequifax.domains.entity.CreditCardTransaction;
import com.projetoequifax.domains.entity.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, UUID> {

    @Query(" SELECT SUM(CASE " +
            " WHEN ts.status = 'APPROVED' THEN -1.0 " +
            " WHEN ts.status = 'PENDING' THEN 0.0 " +
            " WHEN ts.status = 'DECLINED' THEN 5.0 " +
            " ELSE 0.0 END) " +
            " FROM TransactionStatus ts" +
            " INNER JOIN CreditCardTransaction cct ON ts.transactionId = cct.transactionId" +
            " WHERE cct.creditCard = :cpf ")
    BigDecimal getCCScoreByCreditCardCPF(String cpf);

}
