package com.ppossatto.chromaback.transformers.internal.application.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Builder
public record ManufacturerDto(
   UUID externalIdentifier,
   String name,
   String country,
   String website,
   Boolean isActive,
   String contactEmail,
   Set<Long> transformers,
   LocalDateTime createdAt,
   LocalDateTime updatedAt,
   LocalDateTime deletedAt,
   String deletedBy
) {
}
