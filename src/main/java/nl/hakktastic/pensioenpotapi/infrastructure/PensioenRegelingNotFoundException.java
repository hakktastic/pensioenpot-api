package nl.hakktastic.pensioenpotapi.infrastructure;

public class PensioenRegelingNotFoundException extends RuntimeException {

    public PensioenRegelingNotFoundException(String message) {
        super(message);
    }
}