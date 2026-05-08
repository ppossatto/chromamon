package com.ppossatto.chromaback.analyses.internal.application.dto;

import com.ppossatto.chromaback.analyses.internal.domain.enums.BatchStatusType;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Builder
public record AnalysisBatchDto(
   UUID externalIdentifier,
   String submittedBy,
   LocalDateTime submittedAt,
   Integer totalRows,
   int processedRows,
   int skippedRows,
   BatchStatusType status,
   LocalDateTime statusUpdatedAt,
   String errorMessage,
   String enrichedCsvUrl,
   Set<UUID> analysisExternalIdentifiers,
   LocalDateTime createdAt,
   LocalDateTime updatedAt,
   LocalDateTime deletedAt,
   String deletedBy
) {}