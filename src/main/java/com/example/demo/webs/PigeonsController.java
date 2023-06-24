package com.example.demo.webs;

import com.example.demo.model.Pigeon;
import com.example.demo.services.IPigeonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PigeonsController {
    @Autowired
    private IPigeonsService pigeonsService;

    public PigeonsController() {
        System.out.println("constructor");
    }

    @GetMapping("/pigeons")
    public List<Pigeon> getPigeons() {
        return pigeonsService.getPigeons();
    }

    @PostMapping("/pigeons")
    public Pigeon createPigeon(@RequestBody Pigeon pigeon) {
        return pigeonsService.createPigeon(pigeon);
    }

    @GetMapping("/pigeons/{id}")
    public Pigeon getPigeon(@PathVariable UUID id) {
        Optional<Pigeon> pigeon = pigeonsService.getPigeon(id);

        if (pigeon.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pigeon not found");
        }

        return pigeon.get();
    }
}
