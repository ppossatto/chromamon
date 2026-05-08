package com.ppossatto.chromaback.analyses.unit.mappers;

import com.ppossatto.chromaback.UnitTestsConstants;
import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model.AnalysisBatchJpaEntity;
import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model.AnalysisJpaEntity;
import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisBatchDto;
import com.ppossatto.chromaback.analyses.internal.application.mapper.AnalysisBatchMapper;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AnalysisBatchMapperTest {

  private AnalysisBatchMapper analysisBatchMapper = Mappers.getMapper(AnalysisBatchMapper.class);

  @Test
  @DisplayName("From AnalysisBatchJpaEntity to AnalysisBatchDto mapping")
  void fromAnalysisBatchJpaEntityToAnalysisBatchDto() {
    AnalysisBatchDto expectedDto = getAnalysisBatchDto();

    AnalysisBatchJpaEntity entityToBeMapped = getAnalysisBatchJpaEntity();

    AnalysisBatchDto mappedDto = analysisBatchMapper.toDto(entityToBeMapped);

    assertNotNull(mappedDto);
    assertEquals(expectedDto, mappedDto);
  }

  @Test
  @DisplayName("From AnalysisBatchDto to AnalysisBatchJpaEntity mapping")
  void fromAnalysisBatchDtoToAnalysisBatchJpaEntity() {
    AnalysisBatchJpaEntity expectedEntity = getAnalysisBatchJpaEntity();
    expectedEntity.setAnalyses(null);

    AnalysisBatchDto dtoToBeMapped = getAnalysisBatchDto();

    AnalysisBatchJpaEntity responseEntity = analysisBatchMapper.toEntity(dtoToBeMapped);

    assertNotNull(responseEntity);
    assertEquals(expectedEntity, responseEntity);
  }

  private static @NonNull AnalysisBatchJpaEntity getAnalysisBatchJpaEntity() {
    AnalysisBatchJpaEntity entityToBeMapped = new AnalysisBatchJpaEntity();
    entityToBeMapped.setExternalIdentifier(UnitTestsConstants.AnalysisBatch.EXTERNAL_IDENTIFIER);
    entityToBeMapped.setSubmittedBy(UnitTestsConstants.AnalysisBatch.SUBMITTED_BY);
    entityToBeMapped.setSubmittedAt(UnitTestsConstants.AnalysisBatch.SUBMITTED_AT);
    entityToBeMapped.setTotalRows(UnitTestsConstants.AnalysisBatch.TOTAL_ROWS);
    entityToBeMapped.setProcessedRows(UnitTestsConstants.AnalysisBatch.PROCESSED_ROWS);
    entityToBeMapped.setSkippedRows(UnitTestsConstants.AnalysisBatch.SKIPPED_ROWS);
    entityToBeMapped.setStatus(UnitTestsConstants.AnalysisBatch.STATUS_TYPE);
    entityToBeMapped.setStatusUpdatedAt(UnitTestsConstants.AnalysisBatch.STATUS_UPDATED_AT);
    entityToBeMapped.setEnrichedCsvUrl(UnitTestsConstants.AnalysisBatch.ENRICHED_CSV_URL);
    entityToBeMapped.setCreatedAt(UnitTestsConstants.AnalysisBatch.CREATED_AT);
    entityToBeMapped.setUpdatedAt(UnitTestsConstants.AnalysisBatch.UPDATED_AT);
    Set<AnalysisJpaEntity> analyses = new HashSet<>();
    analyses.add(getFirstAnalysisJpaEntity());
    entityToBeMapped.setAnalyses(analyses);
    return entityToBeMapped;
  }

  private static @NonNull AnalysisJpaEntity getFirstAnalysisJpaEntity() {
    AnalysisJpaEntity analysisJpaEntity = new AnalysisJpaEntity();
    analysisJpaEntity.setExternalIdentifier(UnitTestsConstants.Analysis.ANALYSIS_1_EXTERNAL_IDENTIFIER);
    return analysisJpaEntity;
  }

  private static AnalysisBatchDto getAnalysisBatchDto() {
    return AnalysisBatchDto.builder()
       .externalIdentifier(UnitTestsConstants.AnalysisBatch.EXTERNAL_IDENTIFIER)
       .submittedBy(UnitTestsConstants.AnalysisBatch.SUBMITTED_BY)
       .submittedAt(UnitTestsConstants.AnalysisBatch.SUBMITTED_AT)
       .totalRows(UnitTestsConstants.AnalysisBatch.TOTAL_ROWS)
       .processedRows(UnitTestsConstants.AnalysisBatch.PROCESSED_ROWS)
       .skippedRows(UnitTestsConstants.AnalysisBatch.SKIPPED_ROWS)
       .status(UnitTestsConstants.AnalysisBatch.STATUS_TYPE)
       .statusUpdatedAt(UnitTestsConstants.AnalysisBatch.STATUS_UPDATED_AT)
       .enrichedCsvUrl(UnitTestsConstants.AnalysisBatch.ENRICHED_CSV_URL)
       .analysisExternalIdentifiers(
          UnitTestsConstants.AnalysisBatch.ANALYSIS_EXTERNAL_IDENTIFIERS
       )
       .createdAt(UnitTestsConstants.AnalysisBatch.CREATED_AT)
       .updatedAt(UnitTestsConstants.AnalysisBatch.UPDATED_AT)
       .build();
  }
}
