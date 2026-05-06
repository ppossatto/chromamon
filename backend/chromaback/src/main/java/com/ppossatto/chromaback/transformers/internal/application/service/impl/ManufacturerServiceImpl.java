package com.ppossatto.chromaback.transformers.internal.application.service.impl;

import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerDto;
import com.ppossatto.chromaback.transformers.internal.application.port.out.ManufacturerRepository;
import com.ppossatto.chromaback.transformers.internal.application.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManufacturerServiceImpl implements ManufacturerService {

  private final ManufacturerRepository manufacturerRepository;

  @Override
  @Transactional(readOnly = true)
  public ManufacturerDto getManufacturerByExternalIdentifier(UUID externalIdentifier) {
    log.info("Fetching manufacturer by external identifier: {}", externalIdentifier);
    return manufacturerRepository.getManufacturerByExternalIdentifier(externalIdentifier);
  }
}
