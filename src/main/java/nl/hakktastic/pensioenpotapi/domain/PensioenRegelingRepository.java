package nl.hakktastic.pensioenpotapi.domain;

import nl.hakktastic.pensioenpotapi.domain.aggregate.PensioenRegeling;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.BeleggingsrekeningReference;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PensioenRegelingReference;

import java.math.BigDecimal;

public interface PensioenRegelingRepository {

    PensioenRegeling findPensioenRegelingBy(PensioenRegelingReference pensioenRegelingReference);

    BigDecimal getHuidigeWaardeBeleggingen(BeleggingsrekeningReference beleggingsrekeningReference);
}