package com.example.demo.dao;

import com.example.demo.model.Pigeon;
import org.springframework.stereotype.Controller;

import java.util.*;

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
    public Optional<Pigeon> getPigeon(UUID id) {
        return Optional.ofNullable(pigeons.get(id));
    }

    @Override
    public Optional<Pigeon> deletePigeon(UUID id) {
        return Optional.ofNullable(pigeons.remove(id));
    }

    @Override
    public Optional<Pigeon> updatePigeon(Pigeon newPigeon) {
        UUID id = newPigeon.getId();
        if (pigeons.containsKey(id)) {
            pigeons.put(id, newPigeon);
            return Optional.ofNullable(pigeons.get(id));
        }
        return null;
    }
}
