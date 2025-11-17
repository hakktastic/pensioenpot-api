package nl.hakktastic.pensioenpotapi.domain.aggregate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.DienstverbandReference;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PartTimePercentage;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.Salaris;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Dienstverband {

    private final DienstverbandReference DienstverbandReference;
    private final Salaris salaris;
    private final PartTimePercentage partTimePercentage;
}