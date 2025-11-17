package nl.hakktastic.pensioenpotapi.infrastructure;

import nl.hakktastic.pensioenpotapi.domain.PensioenRegelingRepository;
import nl.hakktastic.pensioenpotapi.domain.PensioenRegelingService;
import nl.hakktastic.pensioenpotapi.domain.aggregate.PensioenRegelingProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BeanConfig {

  @Bean
  public PensioenRegelingService pensioenRegelingService(PensioenRegelingRepository pensioenRegelingRepository, PensioenRegelingProvider pensioenRegelingProvider) {
    return PensioenRegelingService.of(pensioenRegelingRepository, pensioenRegelingProvider);
  }

  @Bean
  public PensioenRegelingProvider pensioenRegelingProvider(PensioenRegelingRepository pensioenRegelingRepository) {
    return PensioenRegelingProvider.of(pensioenRegelingRepository);
  }
}