package com.alura.apirefugio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alura.apirefugio.model.Pet;
import com.alura.apirefugio.model.Refugio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/refugios")
public class RefugioController {
    private static final Logger logger = LoggerFactory.getLogger(RefugioController.class);

    private List<Refugio> refugios = new ArrayList<>();

    @GetMapping
    public List<Refugio> getAllRefugios() {
        logger.info("Recibida solicitud para obtener todos los refugios.");
        return refugios;
    }

    @PostMapping
    public ResponseEntity<Refugio> createRefugio(@RequestBody Refugio refugio) {
        logger.info("Recibida solicitud para crear un nuevo refugio: {}", refugio);
        refugios.add(refugio);
        return ResponseEntity.ok(refugio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refugio> getRefugio(@PathVariable Long id) {
        logger.info("Recibida solicitud para obtener un refugio: {}.", id);
        Optional<Refugio> optionalRefugio = refugios.stream()
                .filter(refugio -> refugio.getId().equals(id))
                .findFirst();
        logger.info("El refugio es el siguiente: {}.", optionalRefugio.toString());

        return optionalRefugio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/pets")
    public ResponseEntity<List<Pet>> getPetsByRefugio(@PathVariable Long id) {
        logger.info("Recibida solicitud para obtener una lista de pets del refugio: {}.", id);
        Optional<Refugio> optionalRefugio = refugios.stream()
                .filter(refugio -> refugio.getId().equals(id))
                .findFirst();
        logger.info("La lista de pets: {}.", optionalRefugio.map(refugio -> refugio.getPets().toString()));
        return optionalRefugio.map(refugio -> ResponseEntity.ok(refugio.getPets())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/pets")
    public ResponseEntity<String> createPetInRefugio(@PathVariable Long id, @RequestBody Pet pet) {
        Optional<Refugio> optionalRefugio = refugios.stream()
                .filter(refugio -> refugio.getId().equals(id))
                .findFirst();

        logger.info("Recibida solicitud para crear un pet: {}", pet);
        if (optionalRefugio.isPresent()) {
            Refugio refugio = optionalRefugio.get();
            refugio.getPets().add(pet);
            return ResponseEntity.ok("Pet created and added to refugio successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
