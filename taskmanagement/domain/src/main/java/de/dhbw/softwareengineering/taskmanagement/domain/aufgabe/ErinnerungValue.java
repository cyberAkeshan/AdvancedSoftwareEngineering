package de.dhbw.softwareengineering.taskmanagement.domain.aufgabe;

import java.time.LocalDateTime;

public class ErinnerungValue {

    private String benutzerEmail;
    private LocalDateTime faelligkeit;

    public ErinnerungValue(String benutzerEmail, LocalDateTime faelligkeit) {
        this.benutzerEmail = benutzerEmail;
        this.faelligkeit = faelligkeit;
    }

    public String getBenutzerEmail() {
        return benutzerEmail;
    }

    public void setBenutzerEmail(String benutzerEmail) {
        this.benutzerEmail = benutzerEmail;
    }

    public LocalDateTime getFaelligkeit() {
        return faelligkeit;
    }

    public void setFaelligkeit(LocalDateTime faelligkeit) {
        this.faelligkeit = faelligkeit;
    }
}
