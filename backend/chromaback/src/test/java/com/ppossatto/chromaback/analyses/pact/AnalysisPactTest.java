package com.ppossatto.chromaback.analyses.pact;

import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import au.com.dius.pact.provider.spring.junit5.MockMvcTestTarget;
import com.ppossatto.chromaback.analyses.internal.adapter.in.rest.AnalysisController;
import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisDto;
import com.ppossatto.chromaback.analyses.internal.application.service.AnalysisService;
import com.ppossatto.chromaback.analyses.internal.domain.enums.AnalysisStatus;
import com.ppossatto.chromaback.analyses.internal.domain.enums.InputSourceType;
import com.ppossatto.chromaback.config.TestSecurityConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Provider("Chromaback")
@PactFolder("target/pacts")
@WebMvcTest(AnalysisController.class)
@ActiveProfiles({"test", "pact"})
@Import(TestSecurityConfig.class)
class AnalysisPactTest {

  private static final String ENGINEER = "ROLE_ENGINEER";
  private static final String BACKOFFICE = "ROLE_BACKOFFICE";

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private AnalysisService analysisService;

  private SimpleGrantedAuthority currentAuthority = new SimpleGrantedAuthority(ENGINEER);

  @BeforeEach
  void beforeEach(PactVerificationContext context) {
    context.setTarget(new MockMvcTestTarget(mockMvc));
  }

  @TestTemplate
  @ExtendWith(PactVerificationInvocationContextProvider.class)
  void pactVerificationTestTemplate(PactVerificationContext context,
                                    MockHttpServletRequestBuilder request) {
    request.with(SecurityMockMvcRequestPostProcessors.jwt()
       .authorities(currentAuthority));
    context.verifyInteraction();
  }

  @State("analysis exists for engineer")
  void stateAnalysisForEngineer() {
    currentAuthority = new SimpleGrantedAuthority(ENGINEER);

    when(analysisService.getAnalysisByExternalId(any(UUID.class)))
       .thenReturn(new AnalysisDto(
          UUID.fromString("539c7693-fdb8-4fb3-94dd-feae3c1c4199"),
          "SN-001",
          InputSourceType.MANUAL,
          null,
          "john.doe",
          LocalDateTime.now().minusDays(1L),
          AnalysisStatus.AN,
          LocalDateTime.now().minusHours(2L),
          BigDecimal.valueOf(1.0),
          BigDecimal.valueOf(2.0),
          BigDecimal.valueOf(3.0),
          BigDecimal.valueOf(4.0),
          BigDecimal.valueOf(5.0),
          BigDecimal.valueOf(6.0),
          BigDecimal.valueOf(7.0),
          BigDecimal.valueOf(8.0),
          BigDecimal.valueOf(9.0),
          Map.of(),
          LocalDateTime.now(),
          LocalDateTime.now(),
          null,
          null
       ));
  }

  @State("analysis exists for backoffice")
  void stateAnalysisForBackoffice() {
    currentAuthority = new SimpleGrantedAuthority(BACKOFFICE);

    when(analysisService.getAnalysisByExternalId(any(UUID.class)))
       .thenReturn(new AnalysisDto(
          UUID.fromString("539c7693-fdb8-4fb3-94dd-feae3c1c4199"),
          "SN-001",
          InputSourceType.MANUAL,
          null,
          "john.doe",
          LocalDateTime.now().minusDays(1L),
          AnalysisStatus.AN,
          LocalDateTime.now().minusHours(2L),
          BigDecimal.valueOf(1.0),
          BigDecimal.valueOf(2.0),
          BigDecimal.valueOf(3.0),
          BigDecimal.valueOf(4.0),
          BigDecimal.valueOf(5.0),
          BigDecimal.valueOf(6.0),
          BigDecimal.valueOf(7.0),
          BigDecimal.valueOf(8.0),
          BigDecimal.valueOf(9.0),
          Map.of(),
          LocalDateTime.now(),
          LocalDateTime.now(),
          null,
          null
       ));
  }
}