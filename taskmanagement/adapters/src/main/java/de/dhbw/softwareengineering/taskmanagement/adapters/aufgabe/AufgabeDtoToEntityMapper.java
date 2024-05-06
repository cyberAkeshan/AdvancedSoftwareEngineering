package de.dhbw.softwareengineering.taskmanagement.adapters.aufgabe;

import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeEntity;
import org.springframework.stereotype.Component;

@Component
public class AufgabeDtoToEntityMapper {

    public AufgabeEntity mapDToEntity(AufgabeDto dto) {

        AufgabeEntity entity = new AufgabeEntity();
        entity.setTitel(dto.getTitel());
        entity.setErledigt(dto.isErledigt());
        entity.setKommentar(dto.getKommentar());
        entity.setSchluesselwort(dto.getSchluesselwort());
        entity.setFaelligkeit(dto.getFaelligkeit());
        entity.setBenutzer(dto.getBenutzer());
        return entity;
    }
}
