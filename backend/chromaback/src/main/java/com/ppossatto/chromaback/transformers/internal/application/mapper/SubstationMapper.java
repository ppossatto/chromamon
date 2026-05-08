package com.ppossatto.chromaback.transformers.internal.application.mapper;

import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.SubstationGeoConverter;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.SubstationJpaEntity;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.TransformerJpaEntity;
import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationDto;
import com.ppossatto.chromaback.transformers.internal.domain.model.Coordinates;
import com.ppossatto.chromaback.transformers.internal.domain.model.PolygonCoordinates;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
   componentModel = MappingConstants.ComponentModel.SPRING
)
public interface SubstationMapper {

  @Mapping(target = "transformers", qualifiedByName = "getTransformersIds")
  SubstationDto toDto(SubstationJpaEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "transformers", ignore = true)
  SubstationJpaEntity toEntity(SubstationDto dto);

  default Coordinates map(Point point) {
    return SubstationGeoConverter.fromPointToCoordinates(point);
  }

  default Point map(Coordinates coordinates) {
    return SubstationGeoConverter.fromCoordinatesToPoint(coordinates);
  }

  default PolygonCoordinates map(Polygon polygon) {
    return SubstationGeoConverter.fromPolygonToPolygonCoordinates(polygon);
  }

  default Polygon map(PolygonCoordinates polygonCoordinates) {
    return SubstationGeoConverter.fromPolygonCoordinatesToPolygon(polygonCoordinates);
  }

  @Named("getTransformersIds")
  default Set<Long> getTransformersIds(Set<TransformerJpaEntity> entities){
    return entities.stream().map(TransformerJpaEntity::getId).collect(Collectors.toSet());
  }
}
