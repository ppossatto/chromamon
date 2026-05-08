package com.ppossatto.chromaback.transformers.internal.application.mapper;

import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.ManufacturerJpaEntity;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.TransformerJpaEntity;
import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerDto;
import com.ppossatto.chromaback.transformers.internal.domain.enums.CountryCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
   componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ManufacturerMapper {

  @Mapping(target = "isActive", source = "active")
  @Mapping(target = "transformers", qualifiedByName = "getTransformersIds")
  @Mapping(target = "country", source = "country.displayName")
  ManufacturerDto toDto(ManufacturerJpaEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "transformers", ignore = true)
  @Mapping(target = "country", qualifiedByName = "getCountry")
  ManufacturerJpaEntity toEntity(ManufacturerDto dto);

  @Named("getCountry")
  default CountryCode getCountry(String name) {
    return CountryCode.fromDisplayName(name);
  }

  @Named("getTransformersIds")
  default Set<Long> getTransformersIds(Set<TransformerJpaEntity> entities){
    return entities.stream().map(TransformerJpaEntity::getId).collect(Collectors.toSet());
  }
}
