package com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.impl;

import com.ppossatto.chromaback.transformers.internal.adapter.exception.AdapterErrorMessage;
import com.ppossatto.chromaback.transformers.internal.adapter.exception.AdapterException;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.SubstationJpaRepository;
import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationDto;
import com.ppossatto.chromaback.transformers.internal.application.mapper.SubstationMapper;
import com.ppossatto.chromaback.transformers.internal.application.port.out.SubstationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SubstationRepositoryImpl implements SubstationRepository {

  private final SubstationJpaRepository substationJpaRepository;
  private final SubstationMapper substationMapper;

  @Override
  public SubstationDto getSubstationByExternalId(UUID externalId) {
    return substationJpaRepository
       .findByExternalIdentifier(externalId)
       .map(substationMapper::toDto)
       .orElseThrow(
          () -> new AdapterException(AdapterErrorMessage.SUBSTATION_BY_EXTERNAL_ID_NOT_FOUND, externalId.toString())
       );
  }
}
