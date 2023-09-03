package com.example.demo.dao;

import com.example.demo.model.Pigeon;
import com.example.demo.model.PigeonNotFoundException;
import org.springframework.stereotype.Controller;

import java.util.*;

// rozmawiam z bazą danych (zapytania sql i parsowanie)
@Controller
public class InMemoryPigeonsDAO implements IPigeonsDAO {
    private Map<UUID, Pigeon> pigeons = new HashMap<>();
            /*
            List.of(Pigeon.builder()
                    .id(UUID.randomUUID())
                    .name("Mateusz")
                    .age(26)
                    .status("sexy")
                    .build(),
            new Pigeon(UUID.randomUUID(), "Liza", 24, "sexy as well"));
             */

    @Override
    public List<Pigeon> getPigeons() {
        return pigeons.values().stream().toList();
    }

    @Override
    public void createPigeon(Pigeon pigeon) {
        pigeons.put(pigeon.getId(), pigeon);
    }

    @Override
    public Pigeon getPigeon(UUID id) throws PigeonNotFoundException {
        Pigeon pigeon = pigeons.get(id);
        if (pigeon == null) {
            throw new PigeonNotFoundException();
        }
        return pigeon;
    }

    @Override
    public void deletePigeon(UUID id) throws PigeonNotFoundException {
        Pigeon pigeon = pigeons.remove(id);
        if (pigeon == null) {
            throw new PigeonNotFoundException();
        }

    }

    @Override
    public Pigeon updatePigeon(Pigeon newPigeon) throws  PigeonNotFoundException {
        UUID id = newPigeon.getId();
        if (pigeons.containsKey(id)) {
            pigeons.put(id, newPigeon);
            return newPigeon;
        } else {
            throw new PigeonNotFoundException();
        }
    }
}
