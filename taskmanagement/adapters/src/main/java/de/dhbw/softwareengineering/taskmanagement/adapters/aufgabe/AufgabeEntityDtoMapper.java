package de.dhbw.softwareengineering.taskmanagement.adapters.aufgabe;

import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeEntity;
import org.springframework.stereotype.Component;

@Component
public class AufgabeEntityDtoMapper {

    public AufgabeDto mapEntityToDto(AufgabeEntity entity) {
        AufgabeDto dto = new AufgabeDto();
        dto.setPrioritaet(entity.getPrioritaet().getPrioritaetCode());
        dto.setTitel(entity.getTitel());
        dto.setKommentar(entity.getKommentar());
        dto.setSchluesselwort(entity.getSchluesselwort());
        dto.setErledigt(entity.isErledigt());
        dto.setFaelligkeit(entity.getFaelligkeit());
        dto.setBenutzer(entity.getBenutzer());
        return dto;
    }
}
