package com.projetoequifax.domains.repository;

import com.projetoequifax.domains.entity.CPFRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CPFRatingRepository extends JpaRepository<CPFRating, UUID> {

    Optional<CPFRating> findByCpf(String cpf);

}
