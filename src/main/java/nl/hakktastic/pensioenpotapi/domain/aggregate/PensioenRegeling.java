package nl.hakktastic.pensioenpotapi.domain.aggregate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.BeleggingsrekeningReference;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.BeschikbarePremiePercentage;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Franchise;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PensioenRegelingReference;
import nl.hakktastic.pensioenpotapi.domain.berekening.JaarlijksePremieStortingBerekening;
import nl.hakktastic.pensioenpotapi.domain.berekening.PensioenWaardeBerekening;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class PensioenRegeling {

    private final PensioenRegelingReference pensioenRegelingReference;
    private final Deelnemer deelnemer;
    private final Franchise franchise;
    private final BeschikbarePremiePercentage beschikbarePremiePercentage;
    @Getter
    private final BeleggingsrekeningReference beleggingsrekeningReference;

    public BigDecimal berekenVerwachtePensioenWaarde(int gewenstePensioenleeftijd, BigDecimal huidigeWaardeBeleggingen) {

        final var aantalJarenTotPensioen = deelnemer.getAantalJarenTotPensioen(gewenstePensioenleeftijd);
        final var jaarlijksePremieStorting = berekenJaarlijkePremieStorting();
        final var pensioenWaardeBerekening = PensioenWaardeBerekening.of(huidigeWaardeBeleggingen, aantalJarenTotPensioen, jaarlijksePremieStorting);

        return pensioenWaardeBerekening.bereken();
    }

    private BigDecimal berekenJaarlijkePremieStorting() {

        final var dienstverband = deelnemer.getDienstverband();
        final var salaris = dienstverband.getSalaris();
        final var partTimePercentage = dienstverband.getPartTimePercentage();

        final var jaarlijksePremieStortingBerekening = JaarlijksePremieStortingBerekening.of(salaris, partTimePercentage, franchise, beschikbarePremiePercentage);

        return jaarlijksePremieStortingBerekening.bereken();
    }
}