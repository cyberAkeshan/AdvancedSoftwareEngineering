package de.dhbw.softwareengineering.taskmanagement.plugins.persistence.benutzer;

import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerEntity;
import de.dhbw.softwareengineering.taskmanagement.plugins.persistence.aufgabe.AufgabeJpa;
import de.dhbw.softwareengineering.taskmanagement.plugins.persistence.aufgabe.AufgabeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BenutzerEntityToJpaMapper {

    @Autowired
    BenutzerJpaRepository benutzerJpaRepository;

    @Autowired
    AufgabeJpaRepository aufgabeJpaRepository;

    public BenutzerJpa mapEntityToJpa(BenutzerEntity entity, boolean isNewJpa) throws Exception {

        checkIfInputIsLegit(entity);

        BenutzerJpa jpa = mapEntityIdToJpa(entity, isNewJpa);

        if (entity.getVorname()!= null) {
            mapEntityVornameToJpa(entity, jpa);
        }

        if (entity.getNachname()!= null) {
            mapEntityNachnameToJpa(entity, jpa);
        }

        if (entity.getEmail()!= null) {
            mapEntityEmailToJpa(entity, jpa);
        }

        benutzerJpaRepository.save(jpa);

        if (entity.getAufgaben()!= null) {
            mapEntityAufgabeToJpa(entity);
        }

        return jpa;
    }

    private void checkIfInputIsLegit(BenutzerEntity entity) throws Exception {
        // weggelassen weil Integer

        if (entity.getId() != null) {
            for(String aufgabe : entity.getAufgaben()) {
                if (!aufgabeJpaRepository.existsById(aufgabe)) {
                    throw new Exception("Jpa not found");
                }
            }
        }
    }

    private BenutzerJpa mapEntityIdToJpa(BenutzerEntity entity, boolean isNewJpa) throws Exception {
        if(isNewJpa) {
            return mapEntityIdToNewJpa(entity);
        }
        return mapEntityIdToExistingJpa(entity);
    }

    private BenutzerJpa mapEntityIdToNewJpa(BenutzerEntity entity) throws Exception {
        if (benutzerJpaRepository.existsById(entity.getId())) {
            throw new Exception();
        }

        BenutzerJpa jpa = new BenutzerJpa();
        jpa.setId(entity.getId());
        return jpa;
    }

    private BenutzerJpa mapEntityIdToExistingJpa(BenutzerEntity entity) throws Exception {
        if (benutzerJpaRepository.findById(entity.getId()).isPresent()) {
            return benutzerJpaRepository.findById(entity.getId()).get();
        }
        throw new Exception("Jpa not found");
    }

    private void mapEntityVornameToJpa(BenutzerEntity entity, BenutzerJpa jpa) {
        if (entity.getVorname().isEmpty()) {
            jpa.setVorname(null);
            return;
        }
        jpa.setVorname(entity.getVorname());
    }

    private void mapEntityNachnameToJpa(BenutzerEntity entity, BenutzerJpa jpa) {
        if (entity.getNachname().isEmpty()) {
            jpa.setNachname(null);
            return;
        }
        jpa.setNachname(entity.getNachname());
    }

    private void mapEntityEmailToJpa(BenutzerEntity entity, BenutzerJpa jpa) {
        if (entity.getEmail().isEmpty()) {
            jpa.setEmail(null);
            return;
        }
        jpa.setEmail(entity.getEmail());
    }

    private void mapEntityAufgabeToJpa(BenutzerEntity benutzerEntity) {

        //Nicht mehr enthaltene Aufgaben vom Benutzer entfernen (kann man einfacher mit erledigt machen oder
        List<AufgabeJpa> alteAufgabenVonBenutzer = aufgabeJpaRepository.findByBenutzer(benutzerEntity.getId());
        alteAufgabenVonBenutzer.forEach(alteAufgabe -> {
            if (!benutzerEntity.getAufgaben().contains(alteAufgabe.getTitel())) {
                alteAufgabe.setBenutzer(null);
                aufgabeJpaRepository.save(alteAufgabe);
            }
        });

        List<String> neueAufgabenVonBenutzer = benutzerEntity.getAufgaben();
        for (String s : neueAufgabenVonBenutzer) {
            if (aufgabeJpaRepository.findById(s).isPresent()) {
                AufgabeJpa aufgabeJpa = aufgabeJpaRepository.findById(s).get();

                // Aufgaben vom alten Benutzer löschen
                if (aufgabeJpa.getBenutzer() != null && !aufgabeJpa.getBenutzer().equals(benutzerEntity.getId())) {
                    List<AufgabeJpa> aufgabenVonAltenBenutzer = aufgabeJpaRepository.findByBenutzer(aufgabeJpa.getBenutzer());
                    aufgabenVonAltenBenutzer.remove(aufgabeJpa);
                    aufgabeJpaRepository.saveAll(aufgabenVonAltenBenutzer);
                }

                //Kapitel zum neuen Buch hinzufügen
                aufgabeJpa.setBenutzer(benutzerEntity.getId());
                aufgabeJpaRepository.save(aufgabeJpa);
            }
        }
    }
}


