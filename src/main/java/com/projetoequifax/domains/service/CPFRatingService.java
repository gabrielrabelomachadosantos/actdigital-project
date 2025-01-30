package com.projetoequifax.domains.service;

import com.projetoequifax.domains.dto.CPFRatingResponseDTO;
import com.projetoequifax.domains.entity.CPFRating;
import com.projetoequifax.domains.enums.CPFRatingEnum;
import com.projetoequifax.domains.repository.CPFRatingRepository;
import org.springframework.stereotype.Service;

@Service
public class CPFRatingService {

    private final CPFRatingRepository cpfRatingRepository;

    public CPFRatingService(final CPFRatingRepository cpfRatingRepository) {
        this.cpfRatingRepository = cpfRatingRepository;
    }

    public CPFRatingResponseDTO findByCPF(String cpf) {
        CPFRating cpfRating = cpfRatingRepository.findByCpf(cpf).orElse(new CPFRating(
                null,
                cpf,
                CPFRatingEnum.UNKNOWN
        ));

        return new CPFRatingResponseDTO(cpfRating.getCpf(), String.valueOf(cpfRating.getRating()).toLowerCase());
    }

}
