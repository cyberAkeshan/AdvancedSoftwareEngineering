package de.dhbw.softwareengineering.taskmanagement.plugins.persistence.aufgabe;

import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AufgabeEntitiyToJpaMapper {
    @Autowired
    AufgabeJpaRepository aufgabeJpaRepository;

    public AufgabeJpa mapEntityToJpa(AufgabeEntity entity, boolean isNewJpa) throws Exception {

        checkIfInputIsLegit(entity);

        AufgabeJpa jpa = mapEntityTitelToJpa(entity, isNewJpa);

        if (entity.getBenutzer() != null && (jpa.getBenutzer() == null || !entity.getBenutzer().equals(jpa.getBenutzer()))) {
            mapEntityBenutzerToJpa(entity, jpa);
        }

        if (entity.getFaelligkeit() != null) {
            mapEntityFaelligkeitToJpa(entity, jpa);
        }

        if (entity.getKommentar() != null) {
            mapEntityKommentarToJpa(entity, jpa);
        }

        if (entity.getSchluesselwort() != null) {
            mapEntitySchluesselwortToJpa(entity, jpa);
        }

        mapEntityErledigtToJpa(entity, jpa);

        aufgabeJpaRepository.save(jpa);

        // ?

        return jpa;
    }

    private void checkIfInputIsLegit(AufgabeEntity entity) throws Exception {
        if (entity.getTitel() == null || entity.getTitel().isEmpty() || entity.getTitel().length() > 100) {
            throw new Exception();
        }
        // ?
    }

    private AufgabeJpa mapEntityTitelToJpa (AufgabeEntity entity, boolean isNewJpa) throws Exception {
        if(isNewJpa) {
            return mapEntityTitelToNewJpa(entity);
        }
        return mapEntityTitelToExistingJpa(entity);
    }

    private AufgabeJpa mapEntityTitelToNewJpa(AufgabeEntity entity) throws Exception {
        if(aufgabeJpaRepository.existsById(entity.getTitel())) {
            throw new Exception();
        }

        AufgabeJpa jpa = new AufgabeJpa();
        jpa.setTitel(entity.getTitel());
        return jpa;
    }

    private AufgabeJpa mapEntityTitelToExistingJpa(AufgabeEntity entity) throws Exception {
        if (aufgabeJpaRepository.findById(entity.getTitel()).isPresent()) {
            return aufgabeJpaRepository.findById(entity.getTitel()).get();
        }

        throw new Exception("Jpa not found");
    }

    private void mapEntityFaelligkeitToJpa(AufgabeEntity entity, AufgabeJpa jpa) {
        if(entity.getFaelligkeit() == null) {
            jpa.setFaelligkeit(null);
            return;
        }
        jpa.setFaelligkeit(entity.getFaelligkeit());
    }

    private void mapEntityKommentarToJpa(AufgabeEntity entity, AufgabeJpa jpa) {
        if(entity.getKommentar().isEmpty()) {
            jpa.setKommentar(null);
            return;
        }
        jpa.setKommentar(entity.getKommentar());
    }

    private void mapEntitySchluesselwortToJpa(AufgabeEntity entity, AufgabeJpa jpa) {
        if(entity.getSchluesselwort().isEmpty()) {
            jpa.setSchluesselwort(null);
            return;
        }
        jpa.setSchluesselwort(entity.getSchluesselwort());
    }

    private void mapEntityErledigtToJpa(AufgabeEntity entity, AufgabeJpa jpa) {
        jpa.setErledigt(entity.isErledigt());
    }

    private void mapEntityBenutzerToJpa(AufgabeEntity entity, AufgabeJpa jpa) {
        if(entity.getBenutzer() == null) {
            jpa.setBenutzer(null);
            return;
        }
        jpa.setBenutzer(entity.getBenutzer());
    }

    // ?
}
