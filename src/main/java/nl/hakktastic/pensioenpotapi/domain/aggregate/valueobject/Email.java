package nl.hakktastic.pensioenpotapi.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Email {

  private final String value;

  public static Email of(String value) {
    return new Email(value);
  }
}