package com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransformerByExternalIdResponse extends RepresentationModel<TransformerByExternalIdResponse> {
  private UUID externalIdentifier;
  private String serialNumber;
  private String manufacturerName;
  private String substationName;
  private BigDecimal powerInputKv;
  private BigDecimal efficiencyPercent;
  private BigDecimal powerFactor;
  private Integer phase;
  private BigDecimal primaryVoltageKv;
  private BigDecimal secondaryVoltageKv;
  private String importance;
  private Map<String, Object> uniqueProperties;
  private List<String> imagesUrls;
  private List<String> documentsUrls;
  private String condition;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
