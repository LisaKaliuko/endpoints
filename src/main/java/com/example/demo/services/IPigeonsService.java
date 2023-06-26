package com.example.demo.services;

import com.example.demo.model.Pigeon;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPigeonsService {
    List<Pigeon> getPigeons();

    Pigeon createPigeon(Pigeon pigeon);

    Optional<Pigeon> getPigeon(UUID id);

    Optional<Pigeon> deletePigeon(UUID id);

    Optional<Pigeon> updatePigeon(Pigeon pigeon);
}
