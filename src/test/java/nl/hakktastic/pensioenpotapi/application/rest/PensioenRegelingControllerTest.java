package nl.hakktastic.pensioenpotapi.application.rest;

import static nl.hakktastic.testutils.PensioenRegelingControllerTestData.PATH_GET_PENSIONS_PROJECTIONS;
import static nl.hakktastic.testutils.PensioenRegelingControllerTestData.REQUEST_PARAM_GEWENSTE_PENSIOEN_LEEFTIJD;
import static nl.hakktastic.testutils.PensioenRegelingTestData.VALID_PENSIOEN_REGELING_REFERENCE;

import java.util.UUID;
import nl.hakktastic.pensioenpotapi.PostgreSqlContainerConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.testcontainers.containers.PostgreSQLContainer;

@Import(PostgreSqlContainerConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PensioenRegelingControllerIT {

  @Autowired
  private PostgreSQLContainer<?> postgreSQLContainer;

  @LocalServerPort
  private int port;

  private RestTestClient restTestClient;

  @BeforeEach
  void setup() {
    restTestClient = RestTestClient.bindToServer()
        .baseUrl("http://localhost:" + port)
        .build();
  }

  @Test
  void givenPensioenRegelingExists_whenBerekenVerwachteWaarde_thenReturnPensioenWaarde() {

    restTestClient.get()
        .uri(uriBuilder -> uriBuilder.path(PATH_GET_PENSIONS_PROJECTIONS)
            .queryParam(REQUEST_PARAM_GEWENSTE_PENSIOEN_LEEFTIJD, 61)
            .build(VALID_PENSIOEN_REGELING_REFERENCE.getValue())
        )
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.pensioenRegelingReference").isNotEmpty()
        .jsonPath("$.verwachtePensioenWaarde").isNotEmpty();
  }

  @Test
  void givenPensioenRegelingDoeNotExists_whenBerekenVerwachteWaarde_thenReturnNotFound() {

    final var nonExistingPensioenRegelingReference = UUID.randomUUID().toString();
    restTestClient.get()
        .uri(uriBuilder -> uriBuilder.path(PATH_GET_PENSIONS_PROJECTIONS)
            .queryParam(REQUEST_PARAM_GEWENSTE_PENSIOEN_LEEFTIJD, 61)
            .build(nonExistingPensioenRegelingReference))
        .exchange()
        .expectStatus().isNotFound()
        .expectBody()
        .jsonPath("$.httpStatus").isEqualTo(HttpStatus.NOT_FOUND.value())
        .jsonPath("$.httpMethod").isEqualTo(HttpMethod.GET.toString())
        .jsonPath("$.clientIp").isNotEmpty()
        .jsonPath("$.uri").isNotEmpty()
        .jsonPath("$.message").isEqualTo(String.format("pensioenRegelingReference='%s' not found", nonExistingPensioenRegelingReference));
  }
}