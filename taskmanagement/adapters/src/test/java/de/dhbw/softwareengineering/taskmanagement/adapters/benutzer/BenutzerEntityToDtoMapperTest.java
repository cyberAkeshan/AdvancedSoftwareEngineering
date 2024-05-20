package de.dhbw.softwareengineering.taskmanagement.adapters.benutzer;

import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeEntity;
import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BenutzerEntityToDtoMapperTest {

    BenutzerEntityDtoMapper classUnderTest = new BenutzerEntityDtoMapper();

    @Test
    void mapEntityToDto() {

        Integer id = 1;
        String vorname = "Akeshan";
        String nachname = "Kunarajah";
        String email = "akeshan.kunarajah@gmamil.com";
        List<String> aufgaben = List.of("Aufgabe1", "Aufgabe2", "Aufgabe3");

        BenutzerEntity entity = new BenutzerEntity();
        entity.setId(id);
        entity.setVorname(vorname);
        entity.setNachname(nachname);
        entity.setEmail(email);
        entity.setAufgaben(aufgaben);

        BenutzerDto dto = classUnderTest.mapEntityToDto(entity);

        Assertions.assertEquals(dto.getId(), id);
        Assertions.assertEquals(dto.getVorname(), vorname);
        Assertions.assertEquals(dto.getNachname(), nachname);
        Assertions.assertEquals(dto.getEmail(), email);
        Assertions.assertEquals(dto.getAufgaben(), aufgaben);
    }
}
