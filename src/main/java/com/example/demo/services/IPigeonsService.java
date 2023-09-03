package com.example.demo.services;

import com.example.demo.model.Pigeon;
import com.example.demo.model.PigeonNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPigeonsService {
    List<Pigeon> getPigeons();

    Pigeon createPigeon(Pigeon pigeon);

    Pigeon getPigeon(UUID id) throws PigeonNotFoundException;

    void deletePigeon(UUID id) throws PigeonNotFoundException;

    Pigeon updatePigeon(Pigeon pigeon) throws PigeonNotFoundException;
}
