package com.ppossatto.chromaback.transformers.internal.application.service.impl;

import com.ppossatto.chromaback.transformers.TransformerConditionEvent;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;
import com.ppossatto.chromaback.transformers.internal.application.port.out.TransformerRepository;
import com.ppossatto.chromaback.transformers.internal.application.service.TransformerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransformerServiceImpl implements TransformerService {

  private final TransformerRepository transformerRepository;

  @Override
  @Transactional(readOnly = true)
  public TransformerDto getTransformerByExternalIdentifier(UUID externalIdentifier) {
    log.info("Getting transformer by external identifier: {}", externalIdentifier);
    return transformerRepository.getTransformerByExternalId(externalIdentifier);
  }

  @Override
  @Transactional
  public void setTransformerCondition(TransformerConditionEvent event) {
    log.info("Setting transformer '{}' condition to '{}'", event.serialNumber(), event.condition());
    transformerRepository.updateTransformerCondition(event);
  }
}
