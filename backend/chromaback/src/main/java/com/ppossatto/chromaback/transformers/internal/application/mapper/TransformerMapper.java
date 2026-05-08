package com.ppossatto.chromaback.transformers.internal.application.mapper;

import com.ppossatto.chromaback.transformers.TransformerConditionEvent;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.TransformerJpaEntity;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransformerMapper {

  @Mapping(target = "manufacturerName", source = "manufacturer.name")
  @Mapping(target = "substationName", source = "substation.name")
  @Mapping(target = "uniqueProperties", qualifiedByName = "fromNullToMapInDto")
  @Mapping(target = "documentsUrls", qualifiedByName = "fromNullToListInDto")
  @Mapping(target = "imagesUrls", qualifiedByName = "fromNullToListInDto")
  TransformerDto toDto(TransformerJpaEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "manufacturer", ignore = true)
  @Mapping(target = "substation", ignore = true)
  @Mapping(target = "uniqueProperties", qualifiedByName = "fromEmptyMapToNullEntity")
  @Mapping(target = "imagesUrls", qualifiedByName = "fromEmptyListToNullEntity")
  @Mapping(target = "documentsUrls", qualifiedByName = "fromEmptyListToNullEntity")
  TransformerJpaEntity toEntity(TransformerDto dto);

  @Mapping(target = "entity.condition", expression =
     "java(com.ppossatto.chromaback.transformers.internal.domain.enums.ConditionCode.fromDisplayName(event.condition()))")
  TransformerJpaEntity fromEventToEntity(TransformerConditionEvent event, @MappingTarget TransformerJpaEntity entity);

  @Named("fromNullToMapInDto")
  default Map<String, Object> mapNullToMapInDto(Map<String, Object> entityMap) {
    if(entityMap == null) return Collections.emptyMap();
    return entityMap;
  }

  @Named("fromNullToListInDto")
  default List<String> fromNullToListInDto(List<String> entityList) {
    if(entityList == null) return Collections.emptyList();
    return entityList;
  }

  @Named("fromEmptyMapToNullEntity")
  default Map<String, Object> emptyMapToNullEntity(Map<String, Object> dtoMap) {
    if(dtoMap == null || dtoMap.equals(Collections.emptyMap())) return null;
    return dtoMap;
  }

  @Named("fromEmptyListToNullEntity")
  default List<String> emptyListToNullEntity(List<String> dtoList) {
    if(dtoList == null || dtoList.equals(Collections.emptyList())) return null;
    return dtoList;
  }
}
