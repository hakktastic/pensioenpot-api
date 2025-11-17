package nl.hakktastic.pensioenpotapi.domain.berekening;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.BeschikbarePremiePercentage;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Franchise;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PartTimePercentage;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Salaris;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class JaarlijksePremieStortingBerekening {

    private final Salaris salaris;
    private final PartTimePercentage partTimePercentage;
    private final Franchise franchise;
    private final BeschikbarePremiePercentage beschikbarePremiePercentage;

    public BigDecimal bereken() {

        final var salarisValue = salaris.getValue();
        final var partTimePercentageValue = partTimePercentage.getValue();
        final var franchiseValue = franchise.getValue();
        final var beschikbarePremiePercentageValue = beschikbarePremiePercentage.getValue();

        final var jaarlijksePremieStorting = salarisValue.subtract(franchiseValue)
                .multiply(partTimePercentageValue)
                .multiply(beschikbarePremiePercentageValue);

        log.info("jaarlijksePremieStorting='{}'", jaarlijksePremieStorting);

        return jaarlijksePremieStorting;
    }
}