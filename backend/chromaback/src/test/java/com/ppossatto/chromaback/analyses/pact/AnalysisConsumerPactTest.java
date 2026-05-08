package com.ppossatto.chromaback.analyses.pact;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.ppossatto.chromaback.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "Chromaback")
@ActiveProfiles({"test", "pact"})
class AnalysisConsumerPactTest {

  @Pact(consumer = "ChromaFront")
  RequestResponsePact getAnalysisByExternalId(PactDslWithProvider builder) {
    return builder
       .given("analysis exists for engineer")
       .uponReceiving("a request to get analysis by external id")
       .method("GET")
       .path("/api/analyses/539c7693-fdb8-4fb3-94dd-feae3c1c4199")
       .headers(WebConfig.Constants.VERSION_HEADER, WebConfig.Constants.VERSION_ONE)
       .willRespondWith()
       .status(200)
       .body(new PactDslJsonBody()
          .uuid("externalIdentifier")
          .stringType("transformerSerialNumber")
          .stringType("collectedBy")
          .datetime("collectedAt", "yyyy-MM-dd'T'HH:mm:ssXXX")
          .stringType("status")
          .decimalType("h2Ppm")
          .decimalType("ch4Ppm")
          .decimalType("c2h6Ppm")
          .decimalType("c2h4Ppm")
          .decimalType("c2h2Ppm")
          .decimalType("o2Ppm")
          .decimalType("coPpm")
          .decimalType("co2Ppm")
          .decimalType("n2Ppm")
       )
       .toPact();
  }

  @Test
  @PactTestFor(pactMethod = "getAnalysisByExternalId")
  void testGetAnalysisByExternalId(MockServer mockServer) throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
       .uri(URI.create(mockServer.getUrl() + "/api/analyses/539c7693-fdb8-4fb3-94dd-feae3c1c4199"))
       .GET()
       .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    client.close();

    assertEquals(200, response.statusCode());
  }
}
