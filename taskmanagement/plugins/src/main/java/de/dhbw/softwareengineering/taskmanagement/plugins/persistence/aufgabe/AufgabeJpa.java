package de.dhbw.softwareengineering.taskmanagement.plugins.persistence.aufgabe;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "aufgabe", schema = "taskmanagement")
public class AufgabeJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // braucht man?
    @Column(name = "titel", nullable = false)
    private String titel;

    @Basic
    @Column(name = "kommentar")
    private String kommentar;

    @Basic
    @Column(name = "schluesselwort")
    private String schluesselwort;

    @Basic
    @Column(name = "erledigt")
    private boolean erledigt;

    @Basic
    @Column(name = "faelligkeit")
    private LocalDateTime faelligkeit;

    @Basic
    @Column(name = "benutzer")
    private Integer benutzer;


    public Integer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Integer benutzer) {
        this.benutzer = benutzer;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        AufgabeJpa aufgabeJpa = (AufgabeJpa) o;
        return Objects.equals(titel, aufgabeJpa.titel) && Objects.equals(kommentar, aufgabeJpa.kommentar) && Objects.equals(schluesselwort, aufgabeJpa.schluesselwort) && Objects.equals(faelligkeit, aufgabeJpa.faelligkeit) && Objects.equals(erledigt, aufgabeJpa.erledigt) && Objects.equals(benutzer, aufgabeJpa.benutzer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titel, kommentar, schluesselwort, faelligkeit, erledigt, benutzer);
    }
}