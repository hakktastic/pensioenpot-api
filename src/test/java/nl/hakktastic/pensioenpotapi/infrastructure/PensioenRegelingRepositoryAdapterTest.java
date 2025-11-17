package nl.hakktastic.pensioenpotapi.infrastructure;

import static nl.hakktastic.testutils.PensioenRegelingTestData.VALID_PENSIOEN_REGELING_REFERENCE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.UUID;
import nl.hakktastic.pensioenpotapi.PostgreSqlContainerConfiguration;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PensioenRegelingReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;

@Import(PostgreSqlContainerConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PensioenRegelingRepositoryAdapterTest {

  @Autowired
  private PostgreSQLContainer<?> postgreSQLContainer;

  @Autowired
  private PensioenRegelingRepositoryAdapter pensioenRegelingRepositoryAdapter;

  @Test
  void givenExistingReference_whenFindingPensioenRegeling_thenReturnRegeling() {
    final var result = pensioenRegelingRepositoryAdapter.findPensioenRegelingBy(PensioenRegelingReference.of(VALID_PENSIOEN_REGELING_REFERENCE.getValue()));
    assertThat(result).isNotNull();
  }

  @Test
  void givenNonExistingReference_whenFindingPensioenRegeling_thenThrowNotFoundException() {
    assertThatExceptionOfType(PensioenRegelingNotFoundException.class).isThrownBy(
        () -> pensioenRegelingRepositoryAdapter.findPensioenRegelingBy(PensioenRegelingReference.of(UUID.randomUUID())));
  }
}