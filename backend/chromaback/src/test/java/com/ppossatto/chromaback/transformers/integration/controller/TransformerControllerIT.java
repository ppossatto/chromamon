package com.ppossatto.chromaback.transformers.integration.controller;

import com.ppossatto.chromaback.ChromamonTestContainers;
import com.ppossatto.chromaback.config.TestSecurityConfig;
import com.ppossatto.chromaback.config.WebConfig;
import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.TransformerByExternalIdResponse;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
@ExtendWith(SpringExtension.class)
@Import(TestSecurityConfig.class)
@ImportTestcontainers(ChromamonTestContainers.class)
@ActiveProfiles({"test", "integration"})
@Slf4j
class TransformerControllerIT {

  private static final String EXTERNAL_ID = "07c7144b-912d-4bd3-8a87-d556b565510d";

  @Autowired
  private RestTestClient restClient;

  @Test
  @DisplayName("/api/transformers/{internalIdentifier} endpoint testing")
  @Sql(scripts = "classpath:scripts/transformers/prepare_get_transformer_by_external_id.sql",
     executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
  @Sql(scripts = "classpath:scripts/transformers/cleanup.sql",
     executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
  void testEndpointForGettingTransformerByExternalIdentifier() {

    TransformerByExternalIdResponse response = restClient.get()
       .uri(String.format("/api/transformers/%s", EXTERNAL_ID))
       .header(WebConfig.Constants.VERSION_HEADER, WebConfig.Constants.VERSION_ONE)
       .exchange()
       .expectStatus().isOk()
       .expectHeader().contentType(MediaTypes.HAL_JSON_VALUE)
       .expectBody(TransformerByExternalIdResponse.class)
       .returnResult()
       .getResponseBody();

    assertNotNull(response);
    log.debug(response.toString());
    assertEquals("Siemens", response.getManufacturerName());
    assertEquals("Substation A", response.getSubstationName());
  }
}
