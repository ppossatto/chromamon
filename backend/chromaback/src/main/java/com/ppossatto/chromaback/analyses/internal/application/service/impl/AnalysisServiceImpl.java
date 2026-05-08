package com.ppossatto.chromaback.analyses.internal.application.service.impl;

import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisDto;
import com.ppossatto.chromaback.analyses.internal.application.port.out.AnalysisRepository;
import com.ppossatto.chromaback.analyses.internal.application.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnalysisServiceImpl implements AnalysisService {

  private final AnalysisRepository analysisRepository;

  @Override
  @Transactional(readOnly = true)
  public AnalysisDto getAnalysisByExternalId(UUID externalIdentifier) {
    log.info("Retrieving analysis with external ID: '{}'", externalIdentifier);
    AnalysisDto analysisDto = analysisRepository.getAnalysisByExternalId(externalIdentifier);
    log.debug("Analysis retrieved from database");
    return analysisDto;
  }
}
