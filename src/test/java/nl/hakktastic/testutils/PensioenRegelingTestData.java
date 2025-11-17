package nl.hakktastic.testutils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import nl.hakktastic.pensioenpotapi.domain.aggregate.Deelnemer;
import nl.hakktastic.pensioenpotapi.domain.aggregate.Dienstverband;
import nl.hakktastic.pensioenpotapi.domain.aggregate.PensioenRegeling;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.BeleggingsrekeningReference;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.BeschikbarePremiePercentage;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.DeelnemerReference;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.DienstverbandReference;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Email;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Franchise;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Geboortedatum;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Naam;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PartTimePercentage;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PensioenRegelingReference;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Salaris;

public final class PensioenRegelingTestData {

  public static final BeleggingsrekeningReference VALID_BELEGGINGSREKENING_REFERENCE = BeleggingsrekeningReference.of("PENS-ACC-88420317");
  public static final PensioenRegelingReference VALID_PENSIOEN_REGELING_REFERENCE = PensioenRegelingReference.of(UUID.fromString("33333333-0000-0000-0000-000000000001"));

  public static PensioenRegeling getMockPensioenRegeling() {

    return PensioenRegeling.of(
        VALID_PENSIOEN_REGELING_REFERENCE,
        Deelnemer.of(
            DeelnemerReference.of(UUID.fromString("11111111-0000-0000-0000-000000000001")),
            Naam.of("Jan Test"),
            Email.of("jan.test@example.com"),
            Geboortedatum.of(LocalDate.now().minusYears(60)),
            Dienstverband.of(
                DienstverbandReference.of(UUID.fromString("22222222-0000-0000-0000-000000000001")),
                Salaris.of(BigDecimal.valueOf(60_000)),
                PartTimePercentage.of(BigDecimal.valueOf(0.8))
            )
        ),
        Franchise.of(BigDecimal.valueOf(15_599)),
        BeschikbarePremiePercentage.of(BigDecimal.valueOf(0.05)),
        VALID_BELEGGINGSREKENING_REFERENCE
    );
  }
}