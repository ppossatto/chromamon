package com.ppossatto.chromaback.analyses.internal.adapter.in.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class GetAnalysisByExternalIdResponse extends RepresentationModel<GetAnalysisByExternalIdResponse> {
  private UUID externalIdentifier;
  private String transformerSerialNumber;
  private String inputSourceType;
  private String collectedBy;
  private LocalDateTime collectedAt;
  private String analysisStatus;
  private BigDecimal h2Ppm;
  private BigDecimal ch4Ppm;
  private BigDecimal c2h6Ppm;
  private BigDecimal c2h4Ppm;
  private BigDecimal c2h2Ppm;
  private BigDecimal o2Ppm;
  private BigDecimal coPpm;
  private BigDecimal co2Ppm;
  private BigDecimal n2Ppm;
  private Map<String, Object> observations;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
