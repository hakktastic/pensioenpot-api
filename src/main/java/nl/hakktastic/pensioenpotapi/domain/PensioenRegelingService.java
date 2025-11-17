package nl.hakktastic.pensioenpotapi.domain;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.pensioenpotapi.domain.aggregate.PensioenRegelingProvider;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PensioenRegelingReference;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class PensioenPotService {

  private final PensioenPotRepository pensioenPotRepository;
  private final PensioenRegelingProvider pensioenRegelingProvider;

  public BigDecimal berekenVerwachteWaarde(PensioenRegelingReference pensioenRegelingReference, int gewenstePensioenleeftijd) {

    final var pensioenRegeling = pensioenRegelingProvider.findPensioenRegeling(pensioenRegelingReference);
    final var beleggingsrekeningReference = pensioenRegeling.getBeleggingsrekeningReference();
    final var huidigeWaardeBeleggingen = pensioenPotRepository.getHuidigeWaardeBeleggingen(beleggingsrekeningReference);

    return pensioenRegeling.berekenVerwachtePensioenWaarde(gewenstePensioenleeftijd, huidigeWaardeBeleggingen);
  }
}