package nl.hakktastic.pensioenpotapi.domain;

import java.math.BigDecimal;
import nl.hakktastic.pensioenpotapi.domain.aggregate.PensioenRegeling;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.BeleggingsrekeningReference;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PensioenRegelingReference;

public interface PensioenPotRepository {

  PensioenRegeling findPensioenRegelingBy(PensioenRegelingReference pensioenRegelingReference);

  BigDecimal getHuidigeWaardeBeleggingen(BeleggingsrekeningReference beleggingsrekeningReference);
}