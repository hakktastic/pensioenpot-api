package nl.hakktastic.pensioenpotapi.domain.berekening;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class PensioenWaardeBerekening {

    private static final BigDecimal JAARLIJKSE_RENDEMENT_OP_BELEGGINGEN = BigDecimal.valueOf(0.03);

    private final BigDecimal huidigeWaardeBeleggingen;
    private final Integer aantalJarenTotPensioen;
    private final BigDecimal jaarlijksePremieStorting;

    public BigDecimal bereken() {

        var totaleWaardeBeleggingen = huidigeWaardeBeleggingen;

        for (int i = 0; i < aantalJarenTotPensioen; i++) {
            // (Huidige waarde + Jaarlijkse premiestorting/2)
            final var gemiddeldeInvestering = totaleWaardeBeleggingen.add(jaarlijksePremieStorting.divide(BigDecimal.valueOf(2), 10, RoundingMode.HALF_UP));
            // * rendement
            final var groei = gemiddeldeInvestering.multiply(JAARLIJKSE_RENDEMENT_OP_BELEGGINGEN);
            // Huidige waarde + Jaarlijkse premiestorting
            totaleWaardeBeleggingen = totaleWaardeBeleggingen.add(jaarlijksePremieStorting).add(groei);
        }

        log.info("verwachtePensioenWaarde='{}'", totaleWaardeBeleggingen);
        return totaleWaardeBeleggingen.setScale(2, RoundingMode.HALF_UP);
    }
}