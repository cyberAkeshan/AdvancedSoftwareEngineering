package de.dhbw.softwareengineering.taskmanagement.domain.aufgabe;

import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.time.LocalDateTime;

public class SendErinnerung {

    private BenutzerEntity benutzerEntity; // refactor?
    private AufgabeEntity aufgabeEntity;

    public SendErinnerung(BenutzerEntity benutzerEntity, AufgabeEntity aufgabeEntity) {
        this.benutzerEntity = benutzerEntity;
        this.aufgabeEntity = aufgabeEntity;

        LocalDateTime aktuelleZeit = LocalDateTime.now();
        if (aktuelleZeit.isBefore(aufgabeEntity.getErinnerungValue().getFaelligkeit())) {
            String benutzerEntityEmail = benutzerEntity.getEmail();
            String subject = "Aufgabe ist fällig";
            String message = "Hallo " + benutzerEntity.getVorname() + benutzerEntity.getNachname() + " ihre Aufgabe " + aufgabeEntity.getTitel() + " ist am " + aufgabeEntity.getErinnerungValue().getFaelligkeit() + " fällig";
            sendEmail(benutzerEntityEmail, subject, message);
            System.out.println("Email versendet.");
        }
        else {
            System.out.println("Keine Erinnerung erforderlic. Fälligkeit liegt in der Zukunft");
        }
    }
    public void sendEmail(String toEmail, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("akeshankunarajah@gmail.com");
        message.setTo(toEmail);
        message.setText(text);
        message.setSubject(subject);
    }
}
