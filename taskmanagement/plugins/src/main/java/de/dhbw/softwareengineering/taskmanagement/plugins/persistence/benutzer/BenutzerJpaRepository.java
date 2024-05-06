package de.dhbw.softwareengineering.taskmanagement.plugins.persistence.benutzer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BenutzerJpaRepository extends JpaRepository<BenutzerJpa, Integer> {
}
