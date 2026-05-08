package com.ppossatto.chromaback.analyses.integration.controller;

import com.ppossatto.chromaback.ChromamonTestContainers;
import com.ppossatto.chromaback.analyses.internal.adapter.in.rest.dto.response.GetAnalysisByExternalIdResponse;
import com.ppossatto.chromaback.config.TestSecurityConfig;
import com.ppossatto.chromaback.config.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
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
class AnalysisControllerIT {

  private static final String EXTERNAL_ID = "539c7693-fdb8-4fb3-94dd-feae3c1c4199";

  @Autowired
  private RestTestClient restClient;

  @Test
  @DisplayName("/api/analyses/{internalIdentifier} endpoint testing")
  @Sql(scripts = "classpath:scripts/analyses/prepare_get_analysis_by_external_id.sql",
     executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
  @Sql(scripts = "classpath:scripts/analyses/cleanup.sql",
     executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
  void testEndpointForGettingAnalysisByExternalIdentifier() {

    GetAnalysisByExternalIdResponse response = restClient.get()
       .uri(String.format("/api/analyses/%s", EXTERNAL_ID))
       .header(WebConfig.Constants.VERSION_HEADER, WebConfig.Constants.VERSION_ONE)
       .exchange()
       .expectStatus().isOk()
       .expectHeader().contentType(MediaTypes.HAL_JSON_VALUE)
       .expectBody(new ParameterizedTypeReference<GetAnalysisByExternalIdResponse>() {
       })
       .returnResult()
       .getResponseBody();

    assertNotNull(response);
    assertEquals(EXTERNAL_ID, response.getExternalIdentifier().toString());
    assertNotNull(response.getTransformerSerialNumber());
    assertNotNull(response.getAnalysisStatus());
    assertEquals("Manual", response.getInputSourceType());
    assertNotNull(response.getH2Ppm());
  }
}
