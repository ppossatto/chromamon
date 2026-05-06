package com.ppossatto.chromaback.transformers.internal.application.mapper;

import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.SubstationGeoConverter;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.SubstationJpaEntity;
import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationDto;
import com.ppossatto.chromaback.transformers.internal.domain.model.Coordinates;
import com.ppossatto.chromaback.transformers.internal.domain.model.PolygonCoordinates;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubstationMapper {

  SubstationDto toDto(SubstationJpaEntity entity);

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
}
