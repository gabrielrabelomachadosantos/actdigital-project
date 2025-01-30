package com.projetoequifax.domains.controller;

import com.projetoequifax.domains.dto.TransactionRequestDTO;
import com.projetoequifax.domains.dto.TransactionResponseDTO;
import com.projetoequifax.domains.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/calculate_features")
    public ResponseEntity<TransactionResponseDTO> calculateFeatures(@RequestBody TransactionRequestDTO transactionRequestDTO) throws IOException, InterruptedException {
        return new ResponseEntity<>(transactionService.calculateFeatures(transactionRequestDTO), HttpStatus.OK);
    }

}
