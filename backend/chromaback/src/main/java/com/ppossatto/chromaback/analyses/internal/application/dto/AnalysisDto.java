package com.ppossatto.chromaback.analyses.internal.application.dto;

import com.ppossatto.chromaback.analyses.internal.domain.enums.AnalysisStatus;
import com.ppossatto.chromaback.analyses.internal.domain.enums.InputSourceType;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Builder
public record AnalysisDto(
   UUID externalIdentifier,
   String transformerSerialNumber,
   InputSourceType inputSourceType,
   AnalysisBatchDto analysisBatch,
   String collectedBy,
   LocalDateTime collectedAt,
   AnalysisStatus status,
   LocalDateTime statusUpdatedAt,
   BigDecimal h2Ppm,
   BigDecimal ch4Ppm,
   BigDecimal c2h6Ppm,
   BigDecimal c2h4Ppm,
   BigDecimal c2h2Ppm,
   BigDecimal o2Ppm,
   BigDecimal coPpm,
   BigDecimal co2Ppm,
   BigDecimal n2Ppm,
   Map<String, Object> observations,
   LocalDateTime createdAt,
   LocalDateTime updatedAt,
   LocalDateTime deletedAt,
   String deletedBy
) {
}
