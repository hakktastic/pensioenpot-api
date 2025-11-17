package nl.hakktastic.pensioenpotapi.domain;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DeelnemerReference {

  private final UUID value;

  public static DeelnemerReference of(UUID value) {
    return new DeelnemerReference(value);
  }
}