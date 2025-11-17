package nl.hakktastic.pensioenpotapi.domain;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Geboortedatum {

  private final LocalDate value;

  public static Geboortedatum of(LocalDate value) {
    return new Geboortedatum(value);
  }
}