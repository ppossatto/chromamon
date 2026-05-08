package com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.impl;

import com.ppossatto.chromaback.analyses.internal.adapter.exception.AnalysisAdapterErrorMessage;
import com.ppossatto.chromaback.analyses.internal.adapter.exception.AnalysisAdapterException;
import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.InputSourceTypeJpaRepository;
import com.ppossatto.chromaback.analyses.internal.application.port.out.InputSourceTypeRepository;
import com.ppossatto.chromaback.analyses.internal.domain.enums.InputSourceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InputSourceTypeRepositoryImpl implements InputSourceTypeRepository {

  private final InputSourceTypeJpaRepository inputSourceTypeJpaRepository;

  @Override
  public String getInputSourceTypeName(String name) {
    InputSourceType sourceType = InputSourceType.fromDisplayName(name);
    return inputSourceTypeJpaRepository.findByName(sourceType)
       .map(ist -> ist.getName().getDisplayName())
       .orElseThrow(
          () -> new AnalysisAdapterException(
             AnalysisAdapterErrorMessage.INPUT_SOURCE_TYPE_NOT_FOUND, sourceType.getDisplayName()
          )
       );
  }
}
