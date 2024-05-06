package de.dhbw.softwareengineering.taskmanagement.application;

import de.dhbw.softwareengineering.taskmanagement.adapters.benutzer.BenutzerDto;
import de.dhbw.softwareengineering.taskmanagement.adapters.benutzer.BenutzerDtoToEntityMapper;
import de.dhbw.softwareengineering.taskmanagement.adapters.benutzer.BenutzerEntityDtoMapper;
import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerEntity;
import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BenutzerService {

    @Autowired
    private BenutzerRepository repository;
    @Autowired
    private BenutzerEntityDtoMapper entityToDtoMapper;
    @Autowired
    private BenutzerDtoToEntityMapper dtoToEntityMapper;

    public List<BenutzerDto> findAllBenutzer() {
        List<BenutzerDto> dtos = new ArrayList<>();
        repository.findAll().forEach(entity -> dtos.add(entityToDtoMapper.mapEntityToDto(entity)));
        return dtos;
    }

    public Optional<BenutzerDto> findBenutzerById(Integer id) {
        Optional<BenutzerEntity> entityOptional = repository.findById(id);
        return entityOptional.map(entity -> entityToDtoMapper.mapEntityToDto(entity));
    }

    public BenutzerDto create(BenutzerDto dto) throws Exception {
        BenutzerEntity entity = repository.create(dtoToEntityMapper.mapDToEntity(dto));
        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public BenutzerDto update(BenutzerDto dto) throws Exception {
        BenutzerEntity entity = repository.update(dtoToEntityMapper.mapDToEntity(dto));
        return entityToDtoMapper.mapEntityToDto(entity);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}
