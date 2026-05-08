package com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.impl;

import com.ppossatto.chromaback.analyses.internal.adapter.exception.AnalysisAdapterErrorMessage;
import com.ppossatto.chromaback.analyses.internal.adapter.exception.AnalysisAdapterException;
import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.AnalysisBatchJpaRepository;
import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisBatchDto;
import com.ppossatto.chromaback.analyses.internal.application.mapper.AnalysisBatchMapper;
import com.ppossatto.chromaback.analyses.internal.application.port.out.AnalysisBatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AnalysisBatchRepositoryImpl implements AnalysisBatchRepository {

  private final AnalysisBatchJpaRepository analysisBatchJpaRepository;
  private final AnalysisBatchMapper analysisBatchMapper;

  @Override
  public AnalysisBatchDto findByExternalId(UUID externalIdentifier) {
    return analysisBatchJpaRepository.findByExternalIdentifier(externalIdentifier)
       .map(analysisBatchMapper::toDto)
       .orElseThrow(
          () -> new AnalysisAdapterException(
             AnalysisAdapterErrorMessage.ANALYSIS_BATCH_EXTERNAL_IDENTIFIER_NOT_FOUND, externalIdentifier.toString()
          )
       );
  }
}
