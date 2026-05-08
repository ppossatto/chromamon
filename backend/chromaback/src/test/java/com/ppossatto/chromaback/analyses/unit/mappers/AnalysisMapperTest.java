package com.ppossatto.chromaback.analyses.unit.mappers;

import com.ppossatto.chromaback.UnitTestsConstants;
import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model.AnalysisJpaEntity;
import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model.InputSourceTypeJpaEntity;
import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisDto;
import com.ppossatto.chromaback.analyses.internal.application.mapper.AnalysisMapper;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AnalysisMapperTest {

  private AnalysisMapper analysisMapper = Mappers.getMapper(AnalysisMapper.class);

  @Test
  @DisplayName("From AnalysisJpaEntity to AnalysisDto mapping")
  void fromAnalysisJpaEntityToAnalysisDto() {
    AnalysisDto expectedDto = prepareAnalysisDto();

    AnalysisJpaEntity entityToBeMapped = prepareAnalysisJpaEntity(getInputSourceTypeJpaEntity());

    AnalysisDto mappedDto = analysisMapper.toDto(entityToBeMapped);

    assertNotNull(mappedDto);
    assertEquals(expectedDto, mappedDto);
  }

  private static @NonNull InputSourceTypeJpaEntity getInputSourceTypeJpaEntity() {
    InputSourceTypeJpaEntity inputSourceTypeJpaEntity = new InputSourceTypeJpaEntity();
    inputSourceTypeJpaEntity.setName(UnitTestsConstants.Analysis.INPUT_SOURCE_TYPE);
    return inputSourceTypeJpaEntity;
  }

  @Test
  @DisplayName("From AnalysisDto to AnalysisJpaEntity mapping")
  void fromAnalysisDtoToAnalysisJpaEntity() {
    AnalysisJpaEntity expectedEntity = prepareAnalysisJpaEntity(null);
    expectedEntity.setObservations(null);

    AnalysisDto dtoToBeMapped = prepareAnalysisDto();

    AnalysisJpaEntity mappedEntity = analysisMapper.toEntity(dtoToBeMapped);

    assertNotNull(mappedEntity);
    assertEquals(expectedEntity, mappedEntity);
  }

  private static @NonNull AnalysisDto prepareAnalysisDto() {
    return new AnalysisDto(
       UnitTestsConstants.Analysis.ANALYSIS_1_EXTERNAL_IDENTIFIER,
       UnitTestsConstants.Analysis.TRANSFORMER_SERIAL_NUMBER,
       UnitTestsConstants.Analysis.INPUT_SOURCE_TYPE,
       null,
       UnitTestsConstants.Analysis.COLLECTED_BY,
       UnitTestsConstants.Analysis.COLLECTED_AT,
       UnitTestsConstants.Analysis.ANALYSIS_STATUS,
       UnitTestsConstants.Analysis.STATUS_UPDATED_AT,
       UnitTestsConstants.Analysis.H2_PPM,
       UnitTestsConstants.Analysis.CH4_PPM,
       UnitTestsConstants.Analysis.C2H6_PPM,
       UnitTestsConstants.Analysis.C2H4_PPM,
       UnitTestsConstants.Analysis.C2H2_PPM,
       UnitTestsConstants.Analysis.O2_PPM,
       UnitTestsConstants.Analysis.CO_PPM,
       UnitTestsConstants.Analysis.CO2_PPM,
       UnitTestsConstants.Analysis.N2_PPM,
       Collections.emptyMap(),
       UnitTestsConstants.Analysis.CREATED_AT,
       UnitTestsConstants.Analysis.UPDATED_AT,
       null,
       null
    );
  }

  private static @NonNull AnalysisJpaEntity prepareAnalysisJpaEntity(InputSourceTypeJpaEntity inputSourceTypeJpaEntity) {
    AnalysisJpaEntity entityToBeMapped = new AnalysisJpaEntity();
    entityToBeMapped.setId(1L);
    entityToBeMapped.setExternalIdentifier(UnitTestsConstants.Analysis.ANALYSIS_1_EXTERNAL_IDENTIFIER);
    entityToBeMapped.setTransformerSerialNumber(UnitTestsConstants.Analysis.TRANSFORMER_SERIAL_NUMBER);
    entityToBeMapped.setInputSourceType(inputSourceTypeJpaEntity);
    entityToBeMapped.setCollectedBy(UnitTestsConstants.Analysis.COLLECTED_BY);
    entityToBeMapped.setCollectedAt(UnitTestsConstants.Analysis.COLLECTED_AT);
    entityToBeMapped.setStatus(UnitTestsConstants.Analysis.ANALYSIS_STATUS);
    entityToBeMapped.setStatusUpdatedAt(UnitTestsConstants.Analysis.STATUS_UPDATED_AT);
    entityToBeMapped.setH2Ppm(UnitTestsConstants.Analysis.H2_PPM);
    entityToBeMapped.setCh4Ppm(UnitTestsConstants.Analysis.CH4_PPM);
    entityToBeMapped.setC2h6Ppm(UnitTestsConstants.Analysis.C2H6_PPM);
    entityToBeMapped.setC2h4Ppm(UnitTestsConstants.Analysis.C2H4_PPM);
    entityToBeMapped.setC2h2Ppm(UnitTestsConstants.Analysis.C2H2_PPM);
    entityToBeMapped.setO2Ppm(UnitTestsConstants.Analysis.O2_PPM);
    entityToBeMapped.setCoPpm(UnitTestsConstants.Analysis.CO_PPM);
    entityToBeMapped.setCo2Ppm(UnitTestsConstants.Analysis.CO2_PPM);
    entityToBeMapped.setN2Ppm(UnitTestsConstants.Analysis.N2_PPM);
    entityToBeMapped.setCreatedAt(UnitTestsConstants.Analysis.CREATED_AT);
    entityToBeMapped.setUpdatedAt(UnitTestsConstants.Analysis.UPDATED_AT);
    return entityToBeMapped;
  }
}
