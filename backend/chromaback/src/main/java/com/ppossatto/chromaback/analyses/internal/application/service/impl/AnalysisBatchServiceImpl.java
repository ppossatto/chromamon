package com.ppossatto.chromaback.analyses.internal.application.service.impl;

import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisBatchDto;
import com.ppossatto.chromaback.analyses.internal.application.port.out.AnalysisBatchRepository;
import com.ppossatto.chromaback.analyses.internal.application.service.AnalysisBatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnalysisBatchServiceImpl implements AnalysisBatchService {

  private final AnalysisBatchRepository analysisBatchRepository;

  @Override
  @Transactional(readOnly = true)
  public AnalysisBatchDto getAnalysisBatchByExternalId(UUID externalIdentifier) {
    log.info("Retrieving Analysis Batch with ID: '{}'", externalIdentifier);
    AnalysisBatchDto analysisBatchDto = analysisBatchRepository.findByExternalId(externalIdentifier);
    log.debug("Retrieved analysis batch from the database!");
    return analysisBatchDto;
  }
}
