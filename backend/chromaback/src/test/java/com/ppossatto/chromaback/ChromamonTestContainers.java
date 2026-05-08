package com.ppossatto.chromaback;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.postgresql.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration
public class ChromamonTestContainers {

  @Container
  @ServiceConnection
  static PostgreSQLContainer postgres =
     new PostgreSQLContainer(DockerImageName.parse("postgis/postgis:17-3.5")
        .asCompatibleSubstituteFor("postgres"))
        .withDatabaseName("chromamon")
        .withUsername("user")
        .withPassword("password");
}