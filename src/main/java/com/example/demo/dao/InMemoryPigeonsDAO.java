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
}
