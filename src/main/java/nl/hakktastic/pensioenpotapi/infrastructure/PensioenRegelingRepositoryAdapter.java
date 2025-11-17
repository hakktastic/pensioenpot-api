package nl.hakktastic.pensioenpotapi.infrastructure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.pensioenpotapi.domain.PensioenRegelingRepository;
import nl.hakktastic.pensioenpotapi.domain.aggregate.PensioenRegeling;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.BeleggingsrekeningReference;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PensioenRegelingReference;
import nl.hakktastic.pensioenpotapi.infrastructure.jpa.PensioenRegelingJpaRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
@RequiredArgsConstructor
class PensioenRegelingRepositoryAdapter implements PensioenRegelingRepository {

    private static final BigDecimal MOCK_VALUE_HUIDIGE_WAARDE_BELEGGINGEN = BigDecimal.valueOf(100_000);

    private final PensioenRegelingJpaRepository pensioenRegelingJpaRepository;

    @Override
    public PensioenRegeling findPensioenRegelingBy(PensioenRegelingReference pensioenRegelingReference) {
        final var pensioenRegelingJpaEntity = pensioenRegelingJpaRepository
                .findByPensioenRegelingReference(pensioenRegelingReference.getValue())
                .orElseThrow(() -> new PensioenRegelingNotFoundException(String.format("pensioenRegelingReference='%s' not found", pensioenRegelingReference.getValue()))
                );

        return pensioenRegelingJpaEntity.toPensioenRegeling();
    }

    @Override
    public BigDecimal getHuidigeWaardeBeleggingen(BeleggingsrekeningReference beleggingsrekeningReference) {
        return MOCK_VALUE_HUIDIGE_WAARDE_BELEGGINGEN;
    }
}