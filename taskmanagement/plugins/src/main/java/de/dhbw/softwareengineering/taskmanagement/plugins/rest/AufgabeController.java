package de.dhbw.softwareengineering.taskmanagement.plugins.rest;

import de.dhbw.softwareengineering.taskmanagement.adapters.aufgabe.AufgabeDto;
import de.dhbw.softwareengineering.taskmanagement.application.AufgabeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AufgabeController {
    @Autowired
    AufgabeService aufgabeService;

    @GetMapping("/aufgabe/getAllAufgaben")
    public ResponseEntity<List<AufgabeDto>> getAllAufgaben() { return ResponseEntity.ok(aufgabeService.findAllAufgaben());}

    @GetMapping("/aufgabe/{titel}")
    public ResponseEntity<AufgabeDto> getAufgabe(@PathVariable String titel) {

        Optional<AufgabeDto> aufgabe = aufgabeService.findAufgabeById(titel);

        return aufgabe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("aufgabe/createAufgabe")
    public ResponseEntity<AufgabeDto> createAufgabe(AufgabeDto dto) {
        try {
            return ResponseEntity.ok(aufgabeService.create(dto));
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("aufgabe/updateAufgabe")
    public ResponseEntity<AufgabeDto> updateAufgabe(@RequestBody AufgabeDto dto) {

        try {
            return ResponseEntity.ok(aufgabeService.update(dto));
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().equals("Jpa not found")) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("aufgabe/deleteAufgabe/{titel}")
    public void deleteAufgabe(@PathVariable String titel) {
        aufgabeService.delete(titel);
    }

    @PutMapping("aufgabe/sendErinnerung")
    public void sendErinnerung(@RequestBody AufgabeDto dto) {
        aufgabeService.sendErinnerung(dto);
    }

}
