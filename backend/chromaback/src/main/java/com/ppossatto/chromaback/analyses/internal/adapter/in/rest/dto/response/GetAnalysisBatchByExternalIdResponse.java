package com.ppossatto.chromaback.analyses.internal.adapter.in.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class GetAnalysisBatchByExternalIdResponse extends RepresentationModel<GetAnalysisBatchByExternalIdResponse> {
  private UUID externalIdentifier;
  private LocalDateTime submittedAt;
  private Integer totalRows;
  private Integer processedRows;
  private Integer skippedRows;
  private String status;
  private String errorMessage;
  private String enrichedCsvUrl;
  private Set<UUID> analyses;
}
