package com.ppossatto.chromaback.transformers.internal.application.service.impl;

import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationDto;
import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationWithTransformerDto;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;
import com.ppossatto.chromaback.transformers.internal.application.port.out.SubstationRepository;
import com.ppossatto.chromaback.transformers.internal.application.port.out.TransformerRepository;
import com.ppossatto.chromaback.transformers.internal.application.service.SubstationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class SubstationServiceImpl implements SubstationService {

  private final SubstationRepository substationRepository;
  private final TransformerRepository transformerRepository;

  @Override
  @Transactional(readOnly = true)
  public SubstationWithTransformerDto getSubstationByExternalIdentifier(UUID externalIdentifier) {
    log.info("Fetching substation by external identifier: {}", externalIdentifier);
    SubstationDto substationDto = substationRepository.getSubstationByExternalId(externalIdentifier);
    Set<TransformerDto> transformers = transformerRepository.getTransformersByIds(substationDto.transformers());
    return new SubstationWithTransformerDto(substationDto, transformers);
  }
}
