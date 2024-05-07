package de.dhbw.softwareengineering.taskmanagement.adapters.aufgabe;

import java.time.LocalDateTime;

public class AufgabeDto {

    private String titel;
    private String kommentar;
    private String schluesselwort;
    private boolean erledigt;
    private LocalDateTime faelligkeit;
    private Integer benutzer;
    private PrioritaetDto prioritaet;

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

    public LocalDateTime getFaelligkeit() {
        return faelligkeit;
    }

    public void setFaelligkeit(LocalDateTime faelligkeit) {
        this.faelligkeit = faelligkeit;
    }

    public Integer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Integer benutzer) {
        this.benutzer = benutzer;
    }

    public PrioritaetDto getPrioritaet() {
        return prioritaet;
    }

    public void setPrioritaet(int prioritaetCode) {
        this.prioritaet.setPrioritaet(prioritaetCode);
    }
}
