package nl.hakktastic.pensioenpotapi.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class Deelnemer {

  private final DeelnemerReference deelnemerReference;

  private final Naam naam;
  private final Email email;
  private final Geboortedatum geboortedatum;
  private final GewenstePensioenleeftijd gewenstePensioenleeftijd;
  private final Dienstverband dienstverband;
}