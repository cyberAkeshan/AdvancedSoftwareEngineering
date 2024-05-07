package de.dhbw.softwareengineering.taskmanagement.adapters.benutzer;

import org.springframework.stereotype.Component;
import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerEntity;

@Component
public class BenutzerDtoToEntityMapper {

    public BenutzerEntity mapDToEntity(BenutzerDto dto) {

        BenutzerEntity entity = new BenutzerEntity();
        entity.setId(dto.getId());
        entity.setVorname(dto.getVorname());
        entity.setNachname(dto.getNachname());
        entity.setEmail(dto.getEmail());
        entity.setAufgaben(dto.getAufgaben());
        return entity;
    }
}
