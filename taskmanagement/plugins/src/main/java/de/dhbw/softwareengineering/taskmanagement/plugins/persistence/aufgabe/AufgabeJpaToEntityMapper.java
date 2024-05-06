package de.dhbw.softwareengineering.taskmanagement.plugins.persistence.aufgabe;

import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AufgabeJpaToEntityMapper {

    //@Autowired
    //kommentarJpaRepository kommentarJpaRepository;

    public AufgabeEntity mapJpaToEntity(AufgabeJpa aufgabeJpa) {

        AufgabeEntity aufgabeEntity = new AufgabeEntity();

        aufgabeEntity.setTitel(aufgabeJpa.getTitel());
        aufgabeEntity.setErledigt(aufgabeJpa.isErledigt());
        aufgabeEntity.setFaelligkeit(aufgabeJpa.getFaelligkeit());
        aufgabeEntity.setSchluesselwort(aufgabeJpa.getSchluesselwort());
        aufgabeEntity.setBenutzer(aufgabeJpa.getBenutzer());
        //aufgabeEntity.setKommentar(aufgabeJpa.getKommentar());
        // ....
        return aufgabeEntity;
    }
}
