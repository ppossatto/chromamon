package com.ppossatto.chromaback.transformers.internal.application.service.impl;

import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationDto;
import com.ppossatto.chromaback.transformers.internal.application.port.out.SubstationRepository;
import com.ppossatto.chromaback.transformers.internal.application.service.SubstationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class SubstationServiceImpl implements SubstationService {

  private final SubstationRepository substationRepository;

  @Override
  @Transactional(readOnly = true)
  public SubstationDto getSubstationByExternalIdentifier(UUID externalIdentifier) {
    log.info("Fetching substation by external identifier: {}", externalIdentifier);
    return substationRepository.getSubstationByExternalId(externalIdentifier);
  }
}
