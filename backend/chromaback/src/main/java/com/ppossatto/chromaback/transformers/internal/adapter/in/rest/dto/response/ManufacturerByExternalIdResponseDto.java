package com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
public class ManufacturerByExternalIdResponseDto extends RepresentationModel<ManufacturerByExternalIdResponseDto> {
  private UUID externalIdentifier;
  private String name;
  private String country;
  private String website;
  private Boolean isActive;
  private String contactEmail;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
