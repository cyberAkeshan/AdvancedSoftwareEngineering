package de.dhbw.softwareengineering.taskmanagement.adapters.benutzer;

import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerEntity;
import org.springframework.stereotype.Component;

@Component
public class BenutzerEntityDtoMapper {
    public BenutzerDto mapEntityToDto(BenutzerEntity entity) {
        BenutzerDto dto = new BenutzerDto();
        dto.setId(entity.getId());
        dto.setVorname(entity.getVorname());
        dto.setNachname(entity.getNachname());
        dto.setEmail(entity.getEmail());
        dto.setAufgaben(entity.getAufgaben());
        return dto;
    }
}
