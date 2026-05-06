package com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response;

import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;
import com.ppossatto.chromaback.transformers.internal.domain.model.Coordinates;
import com.ppossatto.chromaback.transformers.internal.domain.model.PolygonCoordinates;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
public class SubstationByExternalIdResponse extends RepresentationModel<SubstationByExternalIdResponse> {
  private UUID externalIdentifier;
  private String name;
  private String address;
  private String operator;
  private Integer voltageLevelKv;
  private Coordinates location;
  private PolygonCoordinates coverageArea;
  private PolygonCoordinates affectedArea;
  private Set<TransformerDto> transformers;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
