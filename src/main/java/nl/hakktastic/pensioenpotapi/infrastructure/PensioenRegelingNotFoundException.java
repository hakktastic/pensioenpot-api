package nl.hakktastic.pensioenpotapi.infrastructure;

public class PensioenRegelingNotFountException extends RuntimeException {

  public PensioenRegelingNotFountException(String message) {
    super(message);
  }
}