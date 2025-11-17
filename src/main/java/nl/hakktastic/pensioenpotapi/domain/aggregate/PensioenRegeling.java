package nl.hakktastic.pensioenpotapi.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class PensioenRegeling {

  private final PensioenRegelingReference pensioenRegelingReference;
  private final Deelnemer deelnemer;
  private final Franchise franchise;
  private final BeschikbarePremiePercentage beschikbarePremiePercentage;

}