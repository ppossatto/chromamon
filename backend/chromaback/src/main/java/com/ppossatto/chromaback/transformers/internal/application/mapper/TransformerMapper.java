package com.ppossatto.chromaback.transformers.internal.application.mapper;

import com.ppossatto.chromaback.transformers.TransformerConditionEvent;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.TransformerJpaEntity;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransformerMapper {

  @Mapping(target = "substationName", source = "substation.name")
  @Mapping(target = "manufacturerName", source = "manufacturer.name")
  TransformerDto toDto(TransformerJpaEntity entity);

  TransformerJpaEntity toEntity(TransformerDto dto);

  @Mapping(target = "entity.condition", expression =
     "java(com.ppossatto.chromaback.transformers.internal.domain.enums.ConditionCode.fromDisplayName(event.condition()))")
  TransformerJpaEntity fromEventToEntity(TransformerConditionEvent event, @MappingTarget TransformerJpaEntity entity);
}
