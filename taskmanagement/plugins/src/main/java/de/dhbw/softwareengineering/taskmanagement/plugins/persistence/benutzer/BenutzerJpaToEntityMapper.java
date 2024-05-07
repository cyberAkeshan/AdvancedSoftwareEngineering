package de.dhbw.softwareengineering.taskmanagement.plugins.persistence.benutzer;

import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeEntity;
import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerEntity;
import de.dhbw.softwareengineering.taskmanagement.plugins.persistence.aufgabe.AufgabeJpa;
import de.dhbw.softwareengineering.taskmanagement.plugins.persistence.aufgabe.AufgabeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class BenutzerJpaToEntityMapper {

    @Autowired
    AufgabeJpaRepository aufgabeJpaRepository;

    public BenutzerEntity mapJpaToEntity(BenutzerJpa benutzerJpa) {
        BenutzerEntity benutzerEntity = new BenutzerEntity();
        benutzerEntity.setId(benutzerJpa.getId());

        benutzerEntity.setVorname(benutzerJpa.getVorname());
        benutzerEntity.setNachname(benutzerJpa.getNachname());
        benutzerEntity.setEmail(benutzerJpa.getEmail());

        List<AufgabeJpa> aufgabenVonBenutzer = aufgabeJpaRepository.findByBenutzer(benutzerJpa.getId());
        aufgabenVonBenutzer.sort(Comparator.comparing(AufgabeJpa::getErinnerung)); // sollte nach Faelligkeit sortiert werden

        List<String> aufgabenTitelVonBenutzer = new ArrayList<>();
        aufgabenVonBenutzer.forEach(AufgabeEntity -> {
            aufgabenTitelVonBenutzer.add(AufgabeEntity.getTitel());
        });

        benutzerEntity.setAufgaben(aufgabenTitelVonBenutzer);

        return benutzerEntity;
    }
}
