package nl.hakktastic.pensioenpotapi.domain;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BeschikbarePremiePercentage {

  public final BigDecimal value;

  public static BeschikbarePremiePercentage of(BigDecimal providedValue) {
    return new BeschikbarePremiePercentage(providedValue);
  }
}