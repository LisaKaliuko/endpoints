package com.example.demo.webs;

import com.example.demo.model.Pigeon;
import com.example.demo.model.PigeonNotFoundException;
import com.example.demo.services.IPigeonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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
    public Pigeon getPigeon(@PathVariable UUID id) throws PigeonNotFoundException {
        return pigeonsService.getPigeon(id);
    }

    @DeleteMapping("/pigeons/{id}")
    public void deletePigeon(@PathVariable UUID id) throws PigeonNotFoundException {
        pigeonsService.deletePigeon(id);
    }

    @PutMapping("pigeons/update")
    public Pigeon updatePigeon(@RequestBody Pigeon newPigeon) throws PigeonNotFoundException {
        return pigeonsService.updatePigeon(newPigeon);
    }

    @ExceptionHandler({PigeonNotFoundException.class})
    public void handlePigeonNotFound() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pigeon not found");
    }
}
