package nl.hakktastic.pensioenpotapi.domain.aggregate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.DeelnemerReference;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Email;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Geboortedatum;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Naam;

import java.time.LocalDate;
import java.time.Period;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Deelnemer {

    private final DeelnemerReference deelnemerReference;

    private final Naam naam;
    private final Email email;
    private final Geboortedatum geboortedatum;
    private final Dienstverband dienstverband;

    public Integer getAantalJarenTotPensioen(int gewenstePensioenleeftijd) {

        final var deelnemerLeeftijd = getHuidigeLeeftijd();
        return gewenstePensioenleeftijd - deelnemerLeeftijd;
    }

    private Integer getHuidigeLeeftijd() {
        return Period.between(geboortedatum.getValue(), LocalDate.now())
                .getYears();
    }
}