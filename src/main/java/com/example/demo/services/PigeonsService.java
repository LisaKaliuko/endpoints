package com.example.demo.services;

import com.example.demo.dao.IPigeonsDAO;
import com.example.demo.model.Pigeon;
import com.example.demo.model.PigeonNotFoundException;
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
    public Pigeon getPigeon(UUID id) throws PigeonNotFoundException {
        return pigeonsDAO.getPigeon(id);
    }

    @Override
    public void deletePigeon(UUID id) throws PigeonNotFoundException {
         pigeonsDAO.deletePigeon(id);
    }

    @Override
    public Pigeon updatePigeon(Pigeon newPigeon) throws PigeonNotFoundException{
        return pigeonsDAO.updatePigeon(newPigeon);
    }
}
