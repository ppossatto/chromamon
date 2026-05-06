package com.ppossatto.chromaback.transformers.internal.application.mapper;

import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.ManufacturerJpaEntity;
import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ManufacturerMapper {

  @Mapping(target = "isActive", source = "active")
  ManufacturerDto toDto(ManufacturerJpaEntity entity);

  ManufacturerJpaEntity toEntity(ManufacturerDto dto);
}
