package nl.hakktastic.pensioenpotapi.domain;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Salaris {
  
  private final BigDecimal value;

  public static Salaris of(BigDecimal providedValue) {
    return new Salaris(providedValue);
  }
}