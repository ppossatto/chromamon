package com.ppossatto.chromaback.transformers.internal.application.service.impl;

import com.ppossatto.chromaback.transformers.TransformerPublicApi;
import com.ppossatto.chromaback.transformers.internal.application.port.out.TransformerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * For Modulith APIs...
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TransformerPublicApiImpl implements TransformerPublicApi {

  private final TransformerRepository transformerRepository;

  @Override
  @Transactional(readOnly = true)
  public List<String> findMissingSerialNumbers(List<String> serialNumbers) {
    log.info("Searching missing serial numbers. Amount to check: {}",
       serialNumbers == null ? "0" : serialNumbers.size());

    if(serialNumbers == null || serialNumbers.isEmpty()){
      log.warn("No serial numbers set for searching!");
      return Collections.emptyList();
    }

    List<String> transformersFound = transformerRepository.getExistingTransformersBySerialNumber(serialNumbers);

    log.debug("Amount of transformers found: {}", transformersFound.size());

    return serialNumbers.stream()
       .filter(sn -> !transformersFound.contains(sn))
       .toList();
  }
}
