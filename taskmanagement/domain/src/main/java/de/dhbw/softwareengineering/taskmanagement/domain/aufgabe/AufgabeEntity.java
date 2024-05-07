package de.dhbw.softwareengineering.taskmanagement.domain.aufgabe;
import java.time.LocalDateTime;

public class AufgabeEntity {

    private String titel;
    private String kommentar;
    private String schluesselwort;
    private boolean erledigt;
    private ErinnerungValue erinnerungValue;
    private Integer benutzer;
    private PrioritaetValue prioritaet;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getSchluesselwort() {
        return schluesselwort;
    }

    public void setSchluesselwort(String schluesselwort) {
        this.schluesselwort = schluesselwort;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }

    public Integer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Integer benutzer) {
        this.benutzer = benutzer;
    }

    public PrioritaetValue getPrioritaet() {
        return prioritaet;
    }

    public void setPrioritaet(int prioritaetCode) {
        this.prioritaet.setPrioritaet(prioritaetCode);
    }

    public ErinnerungValue getErinnerungValue() {
        return erinnerungValue;
    }

    public void setErinnerungValue(LocalDateTime erinnerung) {
        this.erinnerungValue.setFaelligkeit(erinnerung);
    }
}
