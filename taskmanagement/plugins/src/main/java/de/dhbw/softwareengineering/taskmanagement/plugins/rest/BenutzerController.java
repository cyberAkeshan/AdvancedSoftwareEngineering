package de.dhbw.softwareengineering.taskmanagement.plugins.rest;

import de.dhbw.softwareengineering.taskmanagement.adapters.benutzer.BenutzerDto;
import de.dhbw.softwareengineering.taskmanagement.application.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BenutzerController {

    @Autowired
    BenutzerService benutzerService;

    @GetMapping("/benutzer/getAllBenutzer")
    public ResponseEntity<List<BenutzerDto>> getAllBenutzer() { return ResponseEntity.ok(benutzerService.findAllBenutzer()); }

    @GetMapping("/benutzer/{id}")
    public ResponseEntity<BenutzerDto> getBenutzer(@PathVariable Integer id) {
        Optional<BenutzerDto> benutzer = benutzerService.findBenutzerById(id);
        return benutzer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/benutzer/createBenutzer")
    public ResponseEntity<BenutzerDto> createBenutzer(BenutzerDto dto) {
        try {
            return ResponseEntity.ok(benutzerService.create(dto));
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/benutzer/updateBenutzer")
    public ResponseEntity<BenutzerDto> updateBenutzer(@RequestBody BenutzerDto dto) {
        try {
            return ResponseEntity.ok(benutzerService.update(dto));
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/benutzer/deleteBenutzer/{id}")
    public void deleteBenutzer(@PathVariable Integer id) {
        benutzerService.delete(id);
    }
}
