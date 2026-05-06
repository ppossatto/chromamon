package com.ppossatto.chromaback.transformers.internal.adapter.in.rest.mapper;

import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.SubstationByExternalIdResponse;
import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubstationApiMapper {

  @Mapping(target = "add", ignore = true)
  SubstationByExternalIdResponse toResponse(SubstationDto substationDto);
}
