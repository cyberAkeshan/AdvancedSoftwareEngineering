package de.dhbw.softwareengineering.taskmanagement.adapters.aufgabe;

public class PrioritaetDto {

    public enum Prioritaet {
        EINFACH("Einfach",1),
        MITTEL("Mittel",2),
        HOCH("Schwer",3);

        private final String text;
        private final int code;

        Prioritaet(String text, int code) {
            this.text = text;
            this.code = code;
        }

        public String getText() {
            return text;
        }

        public int getCode() {
            return code;
        }
    }

    private Prioritaet prioritaet;

    public PrioritaetDto() {
        this.prioritaet = Prioritaet.EINFACH; // Standardwert: EINFACH
    }

    public Prioritaet getPrioritaet() {
        return prioritaet;
    }

    public void setPrioritaet(int prioritaetCode) {
        switch (prioritaetCode) {
            case 1:
                this.prioritaet = Prioritaet.EINFACH;
                break;
            case 2:
                this.prioritaet = Prioritaet.MITTEL;
                break;
            case 3:
                this.prioritaet = Prioritaet.HOCH;
                break;
            default:
                throw new IllegalArgumentException("Ungültiger Prioritätscode: " + prioritaetCode);
        }
    }

    public int getPrioritaetCode() {
        return prioritaet.getCode();
    }
}
