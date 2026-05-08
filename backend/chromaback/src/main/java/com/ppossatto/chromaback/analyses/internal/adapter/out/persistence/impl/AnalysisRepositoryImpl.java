package com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.impl;

import com.ppossatto.chromaback.analyses.internal.adapter.exception.AnalysisAdapterErrorMessage;
import com.ppossatto.chromaback.analyses.internal.adapter.exception.AnalysisAdapterException;
import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.AnalysisJpaRepository;
import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisDto;
import com.ppossatto.chromaback.analyses.internal.application.mapper.AnalysisMapper;
import com.ppossatto.chromaback.analyses.internal.application.port.out.AnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AnalysisRepositoryImpl implements AnalysisRepository {

  private final AnalysisJpaRepository analysisJpaRepository;
  private final AnalysisMapper analysisMapper;

  @Override
  public AnalysisDto getAnalysisByExternalId(UUID externalId) {
    return analysisJpaRepository.findByExternalIdentifier(externalId)
       .map(analysisMapper::toDto)
       .orElseThrow(
          () -> new AnalysisAdapterException(
             AnalysisAdapterErrorMessage.ANALYSIS_BY_EXTERNAL_ID_NOT_FOUND, externalId.toString()
          )
       );
  }
}
