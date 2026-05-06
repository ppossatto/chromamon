package com.ppossatto.chromaback.transformers.internal.adapter.in.rest.mapper;

import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.ManufacturerByExternalIdResponseDto;
import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
   componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ManufacturerApiMapper {

  @Mapping(target = "add", ignore = true)
  ManufacturerByExternalIdResponseDto toGetManufacturerByExternalIdentifierResponse(ManufacturerDto dto);
}
