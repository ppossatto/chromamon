package com.ppossatto.chromaback.transformers.internal.application.dto;

import com.ppossatto.chromaback.transformers.internal.domain.enums.ConditionCode;
import com.ppossatto.chromaback.transformers.internal.domain.enums.ImportanceCode;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Builder
public record TransformerDto(
   UUID externalIdentifier,
   String serialNumber,
   String manufacturerName,
   String substationName,
   BigDecimal powerInputKv,
   BigDecimal efficiencyPercent,
   BigDecimal powerFactor,
   Integer phase,
   BigDecimal primaryVoltageKv,
   BigDecimal secondaryVoltageKv,
   ImportanceCode importance,
   Map<String, Object> uniqueProperties,
   List<String> imagesUrls,
   List<String> documentsUrls,
   ConditionCode condition,
   LocalDateTime createdAt,
   LocalDateTime updatedAt,
   LocalDateTime deletedAt,
   String deletedBy
) {
}
