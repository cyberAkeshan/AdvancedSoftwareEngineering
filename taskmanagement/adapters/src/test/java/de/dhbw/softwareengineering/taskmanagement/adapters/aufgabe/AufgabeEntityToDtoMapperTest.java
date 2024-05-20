package de.dhbw.softwareengineering.taskmanagement.adapters.aufgabe;

import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AufgabeEntityToDtoMapperTest {

    @Test
    void mapEntityToDto() {
        String titel = "Aufgabe1";
        String kommentar = "Details-Details";
        String schluesselwort = "Uni";
        boolean erledigt = false;
        ErinnerungDto erinnerung = new ErinnerungDto("akeshan.kunarajah@gmail.com", LocalDateTime.now());
        Integer benutzer = 1;
        PrioritaetDto prioritaet = new PrioritaetDto(PrioritaetDto.Prioritaet.EINFACH);

        AufgabeEntity entity = new AufgabeEntity();
        entity.setTitel(titel);
        entity.setKommentar(kommentar);
        entity.setSchluesselwort(schluesselwort);
        entity.setErledigt(erledigt);
        entity.setErinnerungValue(erinnerung.getFaelligkeit());
        entity.setBenutzer(benutzer);
        entity.setPrioritaet(prioritaet.getPrioritaetCode());

        AufgabeDto dto = new AufgabeDto();

        Assertions.assertEquals(dto.getTitel(), titel);
        Assertions.assertEquals(dto.getKommentar(), kommentar);
        Assertions.assertEquals(dto.getSchluesselwort(), schluesselwort);
        Assertions.assertEquals(dto.isErledigt(), erledigt);
        Assertions.assertEquals(dto.getErinnerung().getFaelligkeit(), erinnerung.getFaelligkeit());
        Assertions.assertEquals(dto.getBenutzer(), benutzer);
        Assertions.assertEquals(dto.getPrioritaet().getPrioritaetCode(), prioritaet.getPrioritaetCode());

    }

}
