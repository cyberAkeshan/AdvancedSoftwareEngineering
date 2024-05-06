package de.dhbw.softwareengineering.taskmanagement.adapters.benutzer;

import de.dhbw.softwareengineering.taskmanagement.adapters.aufgabe.AufgabeDto;

import java.util.List;

public class BenutzerDto {

    private Integer id;
    private String vorname;
    private String nachname;
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
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
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

    @Override
    public String toString() {
        return "BenutzerDto{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
