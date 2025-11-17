package nl.hakktastic.pensioenpotapi.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Naam {

  private final String value;

  public static Naam of(String value) {
    return new Naam(value);
  }
}