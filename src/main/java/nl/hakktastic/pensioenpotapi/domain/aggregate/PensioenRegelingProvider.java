package nl.hakktastic.pensioenpotapi.domain.aggregate;

import lombok.RequiredArgsConstructor;
import nl.hakktastic.pensioenpotapi.domain.PensioenRegelingRepository;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PensioenRegelingReference;

@RequiredArgsConstructor(staticName = "of")
public class PensioenRegelingProvider {

    private final PensioenRegelingRepository pensioenRegelingRepository;

    public PensioenRegeling findPensioenRegeling(PensioenRegelingReference pensioenRegelingReference) {
        return pensioenRegelingRepository.findPensioenRegelingBy(pensioenRegelingReference);
    }
}