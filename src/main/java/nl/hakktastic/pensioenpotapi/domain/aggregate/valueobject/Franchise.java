package nl.hakktastic.pensioenpotapi.domain;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Franchise {

  private final BigDecimal value;

  public static Franchise of(BigDecimal providedValue) {
    return new Franchise(providedValue);
  }
}