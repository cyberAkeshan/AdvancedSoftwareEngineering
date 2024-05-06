package de.dhbw.softwareengineering.taskmanagement.domain.benutzer;
import de.dhbw.softwareengineering.taskmanagement.domain.aufgabe.AufgabeEntity;

import java.util.List;

public class BenutzerEntity {

    private Integer id;
    private String vorname;
    private String Nachname;
    private String email;
    private List<String> aufgaben;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String Nachname) {
        this.Nachname= Nachname;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getAufgaben() {
        return aufgaben;
    }

    public void setAufgaben(List<String> aufgaben) {
        this.aufgaben = aufgaben;
    }
}
