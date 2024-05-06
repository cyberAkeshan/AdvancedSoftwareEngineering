package de.dhbw.softwareengineering.taskmanagement.plugins.persistence.benutzer;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "benutzer", schema = "taskmanagement")
public class BenutzerJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "nachname")
    private String nachname;

    @Basic
    @Column(name = "vorname")
    private String vorname;

    @Basic
    @Column(name = "email")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;

        BenutzerJpa benutzerJpa = (BenutzerJpa) o;
        return Objects.equals(id, benutzerJpa.id) && Objects.equals(vorname, benutzerJpa.vorname) && Objects.equals(nachname, benutzerJpa.nachname) && Objects.equals(email, benutzerJpa.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vorname, nachname, email);
    }
}
