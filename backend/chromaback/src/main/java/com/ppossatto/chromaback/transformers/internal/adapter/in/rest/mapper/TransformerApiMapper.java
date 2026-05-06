package com.ppossatto.chromaback.transformers.internal.adapter.in.rest.mapper;

import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.TransformerByExternalIdResponse;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransformerApiMapper {

  @Mapping(target = "add", ignore = true)
  TransformerByExternalIdResponse toResponse(TransformerDto transformerDto);
}
