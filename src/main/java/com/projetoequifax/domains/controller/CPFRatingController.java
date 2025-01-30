package com.projetoequifax.domains.controller;

import com.projetoequifax.domains.dto.CPFRatingResponseDTO;
import com.projetoequifax.domains.service.CPFRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CPFRatingController {

    private final CPFRatingService cpfRatingService;

    public CPFRatingController(CPFRatingService cpfRatingService) {
        this.cpfRatingService = cpfRatingService;
    }

    @GetMapping("/cpf_query")
    public ResponseEntity<CPFRatingResponseDTO> cpfQuery(@RequestParam String cpf) {
        return new ResponseEntity<>(cpfRatingService.findByCPF(cpf), HttpStatus.OK);
    }

}
