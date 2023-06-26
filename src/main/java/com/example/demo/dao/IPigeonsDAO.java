package com.example.demo.dao;

import com.example.demo.model.Pigeon;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPigeonsDAO {
    List<Pigeon> getPigeons();

    void createPigeon(Pigeon pigeon);

    Optional<Pigeon> getPigeon(UUID id);

    Optional<Pigeon> deletePigeon(UUID id);

    Optional<Pigeon> updatePigeon(Pigeon newPigeon);
}
