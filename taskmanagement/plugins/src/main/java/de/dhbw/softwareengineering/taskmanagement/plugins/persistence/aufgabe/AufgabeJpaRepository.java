package de.dhbw.softwareengineering.taskmanagement.plugins.persistence.aufgabe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AufgabeJpaRepository extends JpaRepository<AufgabeJpa, String> {
    @Query(value = "SELECT * FROM TASKMANAGEMENT.AUFGABE WHERE aufgabe = ?1", nativeQuery = true)
    List<AufgabeJpa> findByBenutzer(Integer benutzerId);
}
