package de.dhbw.softwareengineering.taskmanagement.plugins.persistence.benutzer;

import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerEntity;
import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BenutzerRepositoryImpl implements BenutzerRepository {

    @Autowired
    BenutzerJpaRepository benutzerJpaRepository;
    @Autowired
    BenutzerJpaToEntityMapper benutzerJpaToEntityMapper;
    @Autowired
    BenutzerEntityToJpaMapper benutzerEntitiyToJpaMapper;

    @Override
    public List<BenutzerEntity> findAll() {
        List<BenutzerEntity> benutzerEntities = new ArrayList<>();
        List<BenutzerJpa> jpas = benutzerJpaRepository.findAll();

        jpas.forEach(jpa -> {
            benutzerEntities.add(benutzerJpaToEntityMapper.mapJpaToEntity(jpa));
        });
        return benutzerEntities;
    }

    @Override
    public Optional<BenutzerEntity> findById(Integer id) {
        Optional<BenutzerJpa> jpaOptional = benutzerJpaRepository.findById(id);
        return jpaOptional.map(jpa -> benutzerJpaToEntityMapper.mapJpaToEntity(jpa));
    }

    @Override
    public BenutzerEntity create(BenutzerEntity entity) throws Exception {
        BenutzerJpa jpa = benutzerEntitiyToJpaMapper.mapEntityToJpa(entity, true);
        return benutzerJpaToEntityMapper.mapJpaToEntity(jpa);
    }

    @Override
    public BenutzerEntity update(BenutzerEntity entity) throws Exception {
        BenutzerJpa jpa = benutzerEntitiyToJpaMapper.mapEntityToJpa(entity, false);
        return benutzerJpaToEntityMapper.mapJpaToEntity(jpa);
    }

    @Override
    public void delete(Integer id) {
        Optional<BenutzerJpa> jpaOptional = benutzerJpaRepository.findById(id);
        jpaOptional.ifPresent(jpa -> benutzerJpaRepository.delete(jpa));
    }
}
