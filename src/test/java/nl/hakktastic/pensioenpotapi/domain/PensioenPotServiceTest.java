package nl.hakktastic.pensioenpotapi.domain;

import static nl.hakktastic.testutils.PensioenRegelingTestData.VALID_PENSIOEN_REGELING_REFERENCE;
import static nl.hakktastic.testutils.PensioenRegelingTestData.getMockPensioenRegeling;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import nl.hakktastic.pensioenpotapi.domain.aggregate.PensioenRegelingProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PensioenPotServiceTest {

  @InjectMocks
  private PensioenRegelingService pensioenRegelingService;

  @Mock
  private PensioenRegelingRepository pensioenRegelingRepository;

  @Mock
  private PensioenRegelingProvider pensioenRegelingProvider;

  @Test
  void givenPensioenRegelingExists_whenBerekenVerwachteWaarde_thenReturnPensioenWaarde() {

    final var mockPensioenRegeling = getMockPensioenRegeling();
    final var verwachteWaarde = BigDecimal.valueOf(104_802.68);

    when(pensioenRegelingProvider.findPensioenRegeling(any())).thenReturn(mockPensioenRegeling);
    when(pensioenRegelingRepository.getHuidigeWaardeBeleggingen(any())).thenReturn(BigDecimal.valueOf(100_000));

    final var berekendeWaarde = pensioenRegelingService.berekenVerwachteWaarde(VALID_PENSIOEN_REGELING_REFERENCE.getValue(), 61);

    assertThat(berekendeWaarde).isEqualTo(verwachteWaarde);
  }
}