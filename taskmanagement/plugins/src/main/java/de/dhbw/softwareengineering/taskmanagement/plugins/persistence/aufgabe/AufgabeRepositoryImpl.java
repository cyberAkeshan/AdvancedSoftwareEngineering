package de.dhbw.softwareengineering.taskmanagement.plugins.persistence.aufgabe;

import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeEntity;
import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AufgabeRepositoryImpl implements AufgabeRepository {

    @Autowired
    AufgabeJpaRepository aufgabeJpaRepository;
    @Autowired
    AufgabeJpaToEntityMapper aufgabeJpaToEntityMapper;
    @Autowired
    AufgabeEntitiyToJpaMapper aufgabeEntitiyToJpaMapper;


    @Override
    public List<AufgabeEntity> findAll() {
        List<AufgabeEntity> aufgabeEntities = new ArrayList<>();
        List<AufgabeJpa> jpas = aufgabeJpaRepository.findAll();

        jpas.forEach(jpa -> {
            aufgabeEntities.add(aufgabeJpaToEntityMapper.mapJpaToEntity(jpa));
        });

        return aufgabeEntities;
    }

    @Override
    public Optional<AufgabeEntity> findById(String titel) {
        Optional<AufgabeJpa> jpaOptional = aufgabeJpaRepository.findById(titel);
        return jpaOptional.map(jpa -> aufgabeJpaToEntityMapper.mapJpaToEntity(jpa));
    }

    @Override
    public AufgabeEntity create(AufgabeEntity entity) throws Exception {
        AufgabeJpa jpa = aufgabeEntitiyToJpaMapper.mapEntityToJpa(entity, true);
        return aufgabeJpaToEntityMapper.mapJpaToEntity(jpa);
    }

    @Override
    public AufgabeEntity update(AufgabeEntity entity) throws Exception {
        AufgabeJpa jpa = aufgabeEntitiyToJpaMapper.mapEntityToJpa(entity, false);
        return aufgabeJpaToEntityMapper.mapJpaToEntity(jpa);
    }

    @Override
    public void delete(String titel) {
        Optional<AufgabeJpa> jpaOptional = aufgabeJpaRepository.findById(titel);
        jpaOptional.ifPresent(jpa -> aufgabeJpaRepository.delete(jpa));
    }
}
