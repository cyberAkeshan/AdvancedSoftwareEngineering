package de.dhbw.softwareengineering.taskmanagement.adapters.benutzer;

import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BenutzerDtoToEntityMapperTest {

    BenutzerDtoToEntityMapper classUnderTest = new BenutzerDtoToEntityMapper();

    @Test
    void mapDToEntity() {

        Integer id = 1;
        String vorname = "Akeshan";
        String nachname = "Kunarajah";
        String email = "akeshan.kunarajah@gmamil.com";
        List<String> aufgaben = List.of("Aufgabe1", "Aufgabe2", "Aufgabe3");

        BenutzerDto dto = new BenutzerDto();
        dto.setId(id);
        dto.setVorname(vorname);
        dto.setNachname(nachname);
        dto.setEmail(email);
        dto.setAufgaben(aufgaben);

        BenutzerEntity entity = classUnderTest.mapDToEntity(dto);

        Assertions.assertEquals(entity.getId(), id);
        Assertions.assertEquals(entity.getVorname(), vorname);
        Assertions.assertEquals(entity.getNachname(), nachname);
        Assertions.assertEquals(entity.getEmail(), email);
        Assertions.assertEquals(entity.getAufgaben(), aufgaben);
    }
}
