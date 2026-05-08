package com.ppossatto.chromaback.analyses.internal.application.mapper;

import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model.AnalysisJpaEntity;
import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model.InputSourceTypeJpaEntity;
import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisDto;
import com.ppossatto.chromaback.analyses.internal.domain.enums.InputSourceType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Collections;
import java.util.Map;

@Mapper(
   componentModel = MappingConstants.ComponentModel.SPRING
)
public interface AnalysisMapper {

  @Mapping(target = "observations", qualifiedByName = "fromNullToMapInDto")
  @Mapping(target = "inputSourceType", qualifiedByName = "inputSourceTypeEnumVerifier")
  @Mapping(target = "analysisBatch", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
  @Mapping(target = "deletedAt", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
  @Mapping(target = "deletedBy", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
  AnalysisDto toDto(AnalysisJpaEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "inputSourceType", ignore = true)
  @Mapping(target = "analysisBatch", ignore = true)
  @Mapping(target = "observations", qualifiedByName = "fromEmptyMapToNullEntity")
  AnalysisJpaEntity toEntity(AnalysisDto dto);

  @Named("fromNullToMapInDto")
  default Map<String, Object> checkCollectionMap(Map<String, Object> map) {
    if(map == null) {
      return Collections.emptyMap();
    }
    return map;
  }

  @Named("fromEmptyMapToNullEntity")
  default Map<String, Object> emptyMapToNullEntity(Map<String, Object> dtoMap) {
    if(dtoMap == null || dtoMap.equals(Collections.emptyMap())) return null;
    return dtoMap;
  }

  @Named("inputSourceTypeEnumVerifier")
  default InputSourceType inputSourceTypeVerifier(InputSourceTypeJpaEntity istEntity) {
    if(istEntity == null || istEntity.getName() == null) {
      return null;
    }
    return InputSourceType.fromDisplayName(istEntity.getName().getDisplayName());
  }
}
