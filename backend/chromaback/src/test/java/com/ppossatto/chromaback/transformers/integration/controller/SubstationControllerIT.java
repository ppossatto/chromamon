package com.ppossatto.chromaback.transformers.integration.controller;

import com.ppossatto.chromaback.ChromamonTestContainers;
import com.ppossatto.chromaback.config.TestSecurityConfig;
import com.ppossatto.chromaback.config.WebConfig;
import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.SubstationByExternalIdResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
@ExtendWith(SpringExtension.class)
@Import(TestSecurityConfig.class)
@ImportTestcontainers(ChromamonTestContainers.class)
@ActiveProfiles({"test", "integration"})
@Slf4j
class SubstationControllerIT {

  private static final String EXTERNAL_ID = "bf5c0baa-9362-4ebc-908b-94c0506607f6";

  @Autowired
  private RestTestClient restClient;

  @Test
  @DisplayName("/api/substations/{internalIdentifier} endpoint testing")
  @Sql(scripts = "classpath:scripts/transformers/prepare_get_substation_by_external_id.sql",
     executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
  @Sql(scripts = "classpath:scripts/transformers/cleanup.sql",
     executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
  void testEndpointForGettingSubstationByExternalIdentifier() {

    SubstationByExternalIdResponse response = restClient.get()
       .uri(String.format("/api/substations/%s", EXTERNAL_ID))
       .header(WebConfig.Constants.VERSION_HEADER, WebConfig.Constants.VERSION_ONE)
       .exchange()
       .expectStatus().isOk()
       .expectHeader().contentType(MediaTypes.HAL_JSON_VALUE)
       .expectBody(SubstationByExternalIdResponse.class)
       .returnResult()
       .getResponseBody();

    assertNotNull(response);
    assertNotNull(response.getTransformers());
    assertNotNull(response.getLocation());
    assertEquals(EXTERNAL_ID, response.getExternalIdentifier().toString());
    assertFalse(response.getTransformers().isEmpty());
  }
}
