package com.josh.personal.SecretSantaService.repository;

import com.josh.personal.SecretSantaService.entities.Pairing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PairingsRepository extends JpaRepository<Pairing, Integer> {
}
