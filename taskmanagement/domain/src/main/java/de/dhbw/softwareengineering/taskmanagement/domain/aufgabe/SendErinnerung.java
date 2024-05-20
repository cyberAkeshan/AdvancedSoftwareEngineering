package de.dhbw.softwareengineering.taskmanagement.domain.aufgabe;

import de.dhbw.softwareengineering.taskmanagement.domain.benutzer.BenutzerEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.time.LocalDateTime;

public class SendErinnerung {
    private AufgabeEntity aufgabeEntity;

    // Konstruktor, der bei Instanziierung überprüft ob Faelligkeit eingetroffen ist
    public SendErinnerung(String benutzerEmail, AufgabeEntity aufgabeEntity) {
        this.aufgabeEntity = aufgabeEntity;

        LocalDateTime aktuelleZeit = LocalDateTime.now();
        if (aktuelleZeit.isBefore(aufgabeEntity.getErinnerungValue().getFaelligkeit())) {
            String subject = "Aufgabe ist fällig";
            String message = "Die Aufgabe " + aufgabeEntity.getTitel() + " ist am " + aufgabeEntity.getErinnerungValue().getFaelligkeit() + " fällig";
            sendEmail(benutzerEmail, subject, message);
            System.out.println("Email versendet.");
        }
        else {
            System.out.println("Keine Erinnerung erforderlich. Fälligkeit liegt in der Zukunft");
        }
    }

    // Email versenden
    public void sendEmail(String toEmail, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("akeshankunarajah@gmail.com");
        message.setTo(toEmail);
        message.setText(text);
        message.setSubject(subject);
    }
}
