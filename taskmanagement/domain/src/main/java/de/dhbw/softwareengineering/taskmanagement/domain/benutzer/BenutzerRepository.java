package de.dhbw.softwareengineering.taskmanagement.domain.benutzer;

import java.util.List;
import java.util.Optional;

public interface BenutzerRepository {

    public List<BenutzerEntity> findAll();
    public Optional<BenutzerEntity> findById(Integer id);
    public BenutzerEntity create(BenutzerEntity entity) throws Exception;
    public BenutzerEntity update(BenutzerEntity entity) throws Exception;
    public void delete(Integer id);

}
