package nl.hakktastic.pensioenpotapi.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.pensioenpotapi.domain.aggregate.PensioenRegelingProvider;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PensioenRegelingReference;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class PensioenRegelingService {

    private final PensioenRegelingRepository pensioenRegelingRepository;
    private final PensioenRegelingProvider pensioenRegelingProvider;

    public BigDecimal berekenVerwachteWaarde(UUID pensioenRegelingReferenceUUID, int gewenstePensioenleeftijd) {

        final var pensioenRegelingReference = PensioenRegelingReference.of(pensioenRegelingReferenceUUID);
        final var pensioenRegeling = pensioenRegelingProvider.findPensioenRegeling(pensioenRegelingReference);
        final var beleggingsrekeningReference = pensioenRegeling.getBeleggingsrekeningReference();
        final var huidigeWaardeBeleggingen = pensioenRegelingRepository.getHuidigeWaardeBeleggingen(beleggingsrekeningReference);

        return pensioenRegeling.berekenVerwachtePensioenWaarde(gewenstePensioenleeftijd, huidigeWaardeBeleggingen);
    }
}