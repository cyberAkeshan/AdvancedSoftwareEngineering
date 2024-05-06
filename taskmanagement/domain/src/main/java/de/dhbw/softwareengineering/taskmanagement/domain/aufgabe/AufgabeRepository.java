package de.dhbw.softwareengineering.taskmanagement.domain.aufgabe;

import java.util.List;
import java.util.Optional;

public interface AufgabeRepository {

    public List<AufgabeEntity> findAll();
    public Optional<AufgabeEntity> findById(String titel);
    public AufgabeEntity create(AufgabeEntity entity) throws Exception;
    public AufgabeEntity update(AufgabeEntity entity) throws Exception;
    public void delete(String titel);

}
