package com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.impl;

import com.ppossatto.chromaback.transformers.internal.adapter.exception.TransformerAdapterErrorMessage;
import com.ppossatto.chromaback.transformers.internal.adapter.exception.TransformerAdapterException;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.ManufacturerJpaRepository;
import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerDto;
import com.ppossatto.chromaback.transformers.internal.application.mapper.ManufacturerMapper;
import com.ppossatto.chromaback.transformers.internal.application.port.out.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ManufacturerRepositoryImpl implements ManufacturerRepository {

  private final ManufacturerJpaRepository manufacturerJpaRepository;
  private final ManufacturerMapper manufacturerMapper;

  @Override
  public ManufacturerDto getManufacturerByExternalIdentifier(UUID externalId) {
    return manufacturerJpaRepository
       .findByExternalIdentifier(externalId)
       .map(manufacturerMapper::toDto)
       .orElseThrow(
          () -> new TransformerAdapterException(
             TransformerAdapterErrorMessage.MANUFACTURER_BY_EXTERNAL_ID_NOT_FOUND, externalId.toString()
          )
       );
  }
}
