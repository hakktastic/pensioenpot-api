package nl.hakktastic.pensioenpotapi.domain;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PartTimePercentage {

  private final BigDecimal value;

  public static PartTimePercentage of(BigDecimal providedValue) {
    return new PartTimePercentage(providedValue);
  }
}