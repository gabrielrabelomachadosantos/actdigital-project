package com.projetoequifax.domains.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetoequifax.domains.dto.CPFRatingResponseDTO;
import com.projetoequifax.domains.dto.TransactionRequestDTO;
import com.projetoequifax.domains.dto.TransactionResponseDTO;
import com.projetoequifax.domains.enums.CPFRatingEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Optional;

@Service
public class TransactionService {

    public static int DEFAULT_CONNECTION_TIMEOUT_SECONDS = 5;

    private final ObjectMapper objectMapper;
    private final TransactionStatusService transactionStatusService;

    public TransactionService(ObjectMapper objectMapper, TransactionStatusService transactionStatusService) {
        this.objectMapper = objectMapper;
        this.transactionStatusService = transactionStatusService;
    }

    public TransactionResponseDTO calculateFeatures(TransactionRequestDTO transactionRequestDTO) throws IOException, InterruptedException {
        CPFRatingResponseDTO cpfRating = getCpfRating(transactionRequestDTO.getCpf());

        if (CPFRatingEnum.UNKNOWN.name().toLowerCase().equals(cpfRating.getRating())) {
            return new TransactionResponseDTO(
                    transactionRequestDTO.getTotalAmount(),
                    CPFRatingEnum.getRatingByName(cpfRating.getRating()),
                    null);
        }

        BigDecimal ccScore = transactionStatusService.getCCScoreByCreditCardCPF(transactionRequestDTO.getCpf());

        return new TransactionResponseDTO(
                transactionRequestDTO.getTotalAmount(),
                CPFRatingEnum.getRatingByName(cpfRating.getRating()),
                ccScore);
    }

    private CPFRatingResponseDTO getCpfRating(String cpf) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .uri(URI.create("http://localhost:3000/cpf_query?cpf=" + cpf))
                .build();

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(DEFAULT_CONNECTION_TIMEOUT_SECONDS))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), CPFRatingResponseDTO.class);
    }

}
