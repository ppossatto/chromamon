package com.ppossatto.chromaback.transformers.internal.adapter.in.rest.mapper;

import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.ManufacturerByExternalIdResponse;
import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.TransformerRelationsResponse;
import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerWithTransformerDto;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
   componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ManufacturerApiMapper {

  @Mapping(target = "transformers", source = "transformerDtos", qualifiedByName = "mapTransformers")
  @Mapping(target = "externalIdentifier", source = "manufacturerDto.externalIdentifier")
  @Mapping(target = "updatedAt", source = "manufacturerDto.updatedAt")
  @Mapping(target = "createdAt", source = "manufacturerDto.createdAt")
  @Mapping(target = "name", source = "manufacturerDto.name")
  @Mapping(target = "country", source = "manufacturerDto.country")
  @Mapping(target = "contactEmail", source = "manufacturerDto.contactEmail")
  @Mapping(target = "isActive", source = "manufacturerDto.isActive")
  @Mapping(target = "website", source = "manufacturerDto.website")
  ManufacturerByExternalIdResponse toGetManufacturerByExternalIdentifierResponse(
     ManufacturerWithTransformerDto manufacturerWithTransformerDto);

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
