package com.ppossatto.chromaback.transformers.internal.application.dto;

import com.ppossatto.chromaback.transformers.internal.domain.model.Coordinates;
import com.ppossatto.chromaback.transformers.internal.domain.model.PolygonCoordinates;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Builder
public record SubstationDto(
   UUID externalIdentifier,
   String name,
   String address,
   String operator,
   Integer voltageLevelKv,
   Coordinates location,
   PolygonCoordinates coverageArea,
   PolygonCoordinates affectedArea,
   Set<TransformerDto> transformers,
   LocalDateTime createdAt,
   LocalDateTime updatedAt,
   LocalDateTime deletedAt,
   String deletedBy
) {
}
