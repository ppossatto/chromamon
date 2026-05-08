package com.ppossatto.chromaback.transformers.internal.adapter.in.rest.mapper;

import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.SubstationByExternalIdResponse;
import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.TransformerRelationsResponse;
import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationWithTransformerDto;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubstationApiMapper {

  @Mapping(target = "transformers", source = "transformerDtos", qualifiedByName = "mapTransformers")
  @Mapping(target = "name", source = "substationDto.name")
  @Mapping(target = "address", source = "substationDto.address")
  @Mapping(target = "affectedArea", source = "substationDto.affectedArea")
  @Mapping(target = "coverageArea", source = "substationDto.coverageArea")
  @Mapping(target = "createdAt", source = "substationDto.createdAt")
  @Mapping(target = "location", source = "substationDto.location")
  @Mapping(target = "operator", source = "substationDto.operator")
  @Mapping(target = "updatedAt", source = "substationDto.updatedAt")
  @Mapping(target = "voltageLevelKv", source = "substationDto.voltageLevelKv")
  @Mapping(target = "externalIdentifier", source = "substationDto.externalIdentifier")
  SubstationByExternalIdResponse toResponse(SubstationWithTransformerDto substationWithTransformerDto);

  @Named("mapTransformers")
  default Set<TransformerRelationsResponse> transformerToResponse(Set<TransformerDto> transformers) {
    return transformers.stream().map(
       t -> TransformerRelationsResponse.builder()
          .externalIdentifier(t.externalIdentifier())
          .manufacturerName(t.manufacturerName())
          .serialNumber(t.serialNumber())
          .build()
    ).collect(Collectors.toSet());
  }
}
