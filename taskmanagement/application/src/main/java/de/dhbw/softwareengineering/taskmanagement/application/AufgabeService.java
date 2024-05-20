package de.dhbw.softwareengineering.taskmanagement.application;

import de.dhbw.softwareengineering.taskmanagement.adapters.aufgabe.AufgabeDto;
import de.dhbw.softwareengineering.taskmanagement.adapters.aufgabe.AufgabeDtoToEntityMapper;
import de.dhbw.softwareengineering.taskmanagement.adapters.aufgabe.AufgabeEntityDtoMapper;
import de.dhbw.softwareengineering.taskmanagement.adapters.benutzer.BenutzerDto;
import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeEntity;
import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeRepository;
import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.SendErinnerung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AufgabeService {

    @Autowired
    private AufgabeRepository repository;
    @Autowired
    private AufgabeEntityDtoMapper entityToDtoMapper;
    @Autowired
    private AufgabeDtoToEntityMapper dtoEntityMapper;

    public List<AufgabeDto> findAllAufgaben() {
        List<AufgabeDto> dtos = new ArrayList<>();
        repository.findAll().forEach(entity -> dtos.add(entityToDtoMapper.mapEntityToDto(entity)));
        return dtos;
    }

    public Optional<AufgabeDto> findAufgabeById(String titel) {
        Optional<AufgabeEntity> entityOptional = repository.findById(titel);
        return entityOptional.map(entity -> entityToDtoMapper.mapEntityToDto(entity));
    }

    public AufgabeDto create(AufgabeDto dto) throws Exception {
        AufgabeEntity entity = repository.create(dtoEntityMapper.mapDToEntity(dto));
        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public AufgabeDto update(AufgabeDto dto) throws Exception {
        AufgabeEntity entity = repository.update(dtoEntityMapper.mapDToEntity(dto));
        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public void delete(String titel) {
        repository.delete(titel);
    }

    // ??
    public void sendErinnerung (AufgabeDto dto) {
        BenutzerService benutzerService = new BenutzerService();
        Optional<BenutzerDto> benutzerDto = benutzerService.findBenutzerById(dto.getBenutzer());
        AufgabeDtoToEntityMapper dtoEntityMapper = new AufgabeDtoToEntityMapper();

        if(benutzerDto.isPresent()) // ist das refactoring?
        {
            SendErinnerung sendErinnerung = new SendErinnerung(benutzerDto.get().getEmail(), dtoEntityMapper.mapDToEntity(dto));
        }
    }

}
