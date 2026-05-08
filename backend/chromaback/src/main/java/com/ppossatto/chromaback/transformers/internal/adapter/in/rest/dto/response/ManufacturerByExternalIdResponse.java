package com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ManufacturerByExternalIdResponse extends RepresentationModel<ManufacturerByExternalIdResponse> {
  private UUID externalIdentifier;
  private String name;
  private String country;
  private String website;
  private Boolean isActive;
  private Set<TransformerRelationsResponse> transformers;
  private String contactEmail;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
