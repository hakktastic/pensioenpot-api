package nl.hakktastic.pensioenpotapi.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class Dienstverband {

  private final Salaris salaris;
  private final PartTimePercentage partTimePercentage;
}