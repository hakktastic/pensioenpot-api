package nl.hakktastic.pensioenpotapi.domain;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PensioenRegelingReference {

  private final UUID value;

  public static PensioenRegelingReference of(final UUID value) {
    return new PensioenRegelingReference(value);
  }
}