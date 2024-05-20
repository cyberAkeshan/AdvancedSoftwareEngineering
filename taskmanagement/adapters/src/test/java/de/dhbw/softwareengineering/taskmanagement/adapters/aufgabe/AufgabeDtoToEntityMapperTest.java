package de.dhbw.softwareengineering.taskmanagement.adapters.aufgabe;

import de.dhbw.softwareengineering.taskmanagement.adapters.benutzer.BenutzerDtoToEntityMapper;
import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AufgabeDtoToEntityMapperTest {

    AufgabeDtoToEntityMapper classUnderTest = new AufgabeDtoToEntityMapper();

    @Test
    void mapDToEntity() {

        String titel = "Aufgabe1";
        String kommentar = "Details-Details";
        String schluesselwort = "Uni";
        boolean erledigt = false;
        ErinnerungDto erinnerung = new ErinnerungDto("akeshan.kunarajah@gmail.com", LocalDateTime.now());
        Integer benutzer = 1;
        PrioritaetDto prioritaet = new PrioritaetDto(PrioritaetDto.Prioritaet.EINFACH);

        AufgabeDto dto = new AufgabeDto();
        dto.setTitel(titel);
        dto.setKommentar(kommentar);
        dto.setSchluesselwort(schluesselwort);
        dto.setErledigt(erledigt);
        dto.setErinnerung(erinnerung.getFaelligkeit());
        dto.setBenutzer(benutzer);
        dto.setPrioritaet(prioritaet.getPrioritaetCode());

        AufgabeEntity entity = classUnderTest.mapDToEntity(dto);

        Assertions.assertEquals(entity.getTitel(),titel);
        Assertions.assertEquals(entity.getKommentar(),kommentar);
        Assertions.assertEquals(entity.getSchluesselwort(),schluesselwort);
        Assertions.assertEquals(entity.isErledigt(),erledigt);
        Assertions.assertEquals(entity.getErinnerungValue().getFaelligkeit(),erinnerung.getFaelligkeit());
        Assertions.assertEquals(entity.getBenutzer(),benutzer);
        Assertions.assertEquals(entity.getPrioritaet().getPrioritaetCode(),prioritaet.getPrioritaetCode());
    }
}
