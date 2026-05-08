package com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.impl;

import com.ppossatto.chromaback.transformers.internal.adapter.exception.TransformerAdapterErrorMessage;
import com.ppossatto.chromaback.transformers.internal.adapter.exception.TransformerAdapterException;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.SubstationJpaRepository;
import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationDto;
import com.ppossatto.chromaback.transformers.internal.application.mapper.SubstationMapper;
import com.ppossatto.chromaback.transformers.internal.application.port.out.SubstationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SubstationRepositoryImpl implements SubstationRepository {

  private final SubstationJpaRepository substationJpaRepository;
  private final SubstationMapper substationMapper;

  @Override
  public SubstationDto getSubstationByExternalId(UUID externalId) {
    log.info("Getting substation entity...");
    return substationJpaRepository
       .findByExternalIdentifier(externalId)
       .map(substationMapper::toDto)
       .orElseThrow(
          () -> new TransformerAdapterException(TransformerAdapterErrorMessage.SUBSTATION_BY_EXTERNAL_ID_NOT_FOUND, externalId.toString())
       );
  }
}
