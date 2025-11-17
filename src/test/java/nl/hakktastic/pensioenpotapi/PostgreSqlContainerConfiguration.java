package nl.hakktastic.pensioenpotapi;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainerConfig {

  @Bean
  PostgreSQLContainer<?> postgreSQLContainer() {
    return new PostgreSQLContainer<>(DockerImageName.parse("postgres:15.15-alpine3.22"));
  }
}