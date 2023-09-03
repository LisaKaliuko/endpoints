package com.example.demo.dao;

import com.example.demo.model.Pigeon;
import com.example.demo.model.PigeonNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPigeonsDAO {
    List<Pigeon> getPigeons();

    void createPigeon(Pigeon pigeon);

    Pigeon getPigeon(UUID id) throws PigeonNotFoundException;

    void deletePigeon(UUID id) throws PigeonNotFoundException;

    Pigeon updatePigeon(Pigeon newPigeon) throws PigeonNotFoundException;
}
