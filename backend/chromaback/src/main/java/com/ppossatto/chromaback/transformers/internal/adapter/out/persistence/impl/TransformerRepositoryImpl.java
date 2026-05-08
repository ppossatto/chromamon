package com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.impl;

import com.ppossatto.chromaback.transformers.TransformerConditionEvent;
import com.ppossatto.chromaback.transformers.internal.adapter.exception.TransformerAdapterErrorMessage;
import com.ppossatto.chromaback.transformers.internal.adapter.exception.TransformerAdapterException;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.TransformerJpaRepository;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.TransformerJpaEntity;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;
import com.ppossatto.chromaback.transformers.internal.application.mapper.TransformerMapper;
import com.ppossatto.chromaback.transformers.internal.application.port.out.TransformerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TransformerRepositoryImpl implements TransformerRepository {

  private final TransformerJpaRepository transformerJpaRepository;
  private final TransformerMapper transformerMapper;

  @Override
  public TransformerDto getTransformerByExternalId(UUID externalId) {
    return transformerJpaRepository
       .findByExternalIdentifier(externalId)
       .map(transformerMapper::toDto)
       .orElseThrow(
          () -> new TransformerAdapterException(TransformerAdapterErrorMessage.TRANSFORMER_BY_EXTERNAL_ID_NOT_FOUND, externalId.toString())
       );
  }

  @Override
  public List<String> getExistingTransformersBySerialNumber(List<String> serialNumbers) {
    return transformerJpaRepository.findBySerialNumbers(serialNumbers);
  }

  @Override
  public void updateTransformerCondition(TransformerConditionEvent event) {
    TransformerJpaEntity entity = transformerJpaRepository
       .findBySerialNumber(event.serialNumber())
       .orElseThrow(() -> new TransformerAdapterException(
          TransformerAdapterErrorMessage.TRANSFORMER_SERIAL_NUMBER_NOT_FOUND,
          event.serialNumber()));
    transformerJpaRepository.save(transformerMapper.fromEventToEntity(event, entity));
  }

  @Override
  public Set<TransformerDto> getTransformersByIds(Set<Long> id) {
    return transformerJpaRepository.findAllById(id)
       .stream()
       .map(transformerMapper::toDto)
       .collect(Collectors.toSet());
  }
}
