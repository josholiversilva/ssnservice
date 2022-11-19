package com.josh.personal.SecretSantaService.dao;

import com.josh.personal.SecretSantaService.entities.Pairing;
import com.josh.personal.SecretSantaService.repository.PairingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PairingsDAO {
    @Autowired
    private PairingsRepository repository;

    public Pairing postPairing(Pairing pairing) {
        return repository.save(pairing);
    }

    public Pairing getPairingById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
