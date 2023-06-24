package com.example.demo.services;

import com.example.demo.dao.IPigeonsDAO;
import com.example.demo.model.Pigeon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class PigeonsService implements IPigeonsService {
    @Autowired
    private IPigeonsDAO pigeonsDAO;

    @Override
    public List<Pigeon> getPigeons() {
        // TODO: Authorization, authentication, validation
        return pigeonsDAO.getPigeons();
    }

    @Override
    public Pigeon createPigeon(Pigeon pigeon) {
        pigeon = pigeon
                .withId(UUID.randomUUID());
        pigeonsDAO.createPigeon(pigeon);
        return pigeon;
    }

    @Override
    public Optional<Pigeon> getPigeon(UUID id) {
        return pigeonsDAO.getPigeon(id);
    }
}
