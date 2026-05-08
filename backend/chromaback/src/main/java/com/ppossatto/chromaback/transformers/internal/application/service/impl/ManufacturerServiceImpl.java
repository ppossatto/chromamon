package com.ppossatto.chromaback.transformers.internal.application.service.impl;

import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerDto;
import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerWithTransformerDto;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;
import com.ppossatto.chromaback.transformers.internal.application.port.out.ManufacturerRepository;
import com.ppossatto.chromaback.transformers.internal.application.port.out.TransformerRepository;
import com.ppossatto.chromaback.transformers.internal.application.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManufacturerServiceImpl implements ManufacturerService {

  private final ManufacturerRepository manufacturerRepository;
  private final TransformerRepository transformerRepository;

  @Override
  @Transactional(readOnly = true)
  public ManufacturerWithTransformerDto getManufacturerByExternalIdentifier(UUID externalIdentifier) {
    log.info("Fetching manufacturer by external identifier: {}", externalIdentifier);
    ManufacturerDto manufacturer = manufacturerRepository.getManufacturerByExternalIdentifier(externalIdentifier);
    Set<TransformerDto> transformers = transformerRepository.getTransformersByIds(manufacturer.transformers());
    return new ManufacturerWithTransformerDto(manufacturer, transformers);
  }
}
