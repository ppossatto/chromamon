package com.ppossatto.chromaback.transformers.unit.mappers;

import com.ppossatto.chromaback.UnitTestsConstants;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.SubstationJpaEntity;
import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationDto;
import com.ppossatto.chromaback.transformers.internal.application.mapper.SubstationMapper;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SubstationMapperTest {

  private static final GeometryFactory FACTORY = new GeometryFactory();

  private SubstationMapper substationMapper = Mappers.getMapper(SubstationMapper.class);

  @Test
  @DisplayName("From SubstationJpaEntity to SubstationDto mapping")
  void fromSubstationJpaEntityToSubstationDto() {

    SubstationDto expectedDto = getSubstationDto();

    SubstationDto mappedSubstationDto = substationMapper.toDto(getSubstationJpaEntity());

    assertNotNull(mappedSubstationDto);
    assertEquals(expectedDto, mappedSubstationDto);
  }

  @Test
  @DisplayName("From SubstationDto to SubstationJpaEntity mapping")
  void fromSubstationDtoToSubstationJpaEntity() {
    SubstationJpaEntity expectedEntity = getSubstationJpaEntity();

    SubstationJpaEntity entityResponse = substationMapper.toEntity(getSubstationDto());

    assertNotNull(entityResponse);
    assertEquals(expectedEntity, entityResponse);
  }

  private static SubstationDto getSubstationDto() {
    return SubstationDto.builder()
       .externalIdentifier(UnitTestsConstants.Substation.EXTERNAL_IDENTIFIER)
       .name(UnitTestsConstants.Substation.SUBSTATION_NAME)
       .address(UnitTestsConstants.Substation.SUBSTATION_ADDRESS)
       .operator(UnitTestsConstants.Substation.OPERATOR)
       .voltageLevelKv(UnitTestsConstants.Substation.VOLTAGE_LEVEL_KV)
       .location(UnitTestsConstants.Substation.LOCATION)
       .coverageArea(UnitTestsConstants.Substation.COVERAGE_AREA_CLOSED)
       .affectedArea(UnitTestsConstants.Substation.AFFECTED_AREA_CLOSED)
       .createdAt(UnitTestsConstants.Substation.CREATED_AT)
       .updatedAt(UnitTestsConstants.Substation.UPDATED_AT)
       .build();
  }

  private static @NonNull SubstationJpaEntity getSubstationJpaEntity() {
    SubstationJpaEntity substationJpaEntity = new SubstationJpaEntity();
    substationJpaEntity.setExternalIdentifier(UnitTestsConstants.Substation.EXTERNAL_IDENTIFIER);
    substationJpaEntity.setName(UnitTestsConstants.Substation.SUBSTATION_NAME);
    substationJpaEntity.setAddress(UnitTestsConstants.Substation.SUBSTATION_ADDRESS);
    substationJpaEntity.setOperator(UnitTestsConstants.Substation.OPERATOR);
    substationJpaEntity.setVoltageLevelKv(UnitTestsConstants.Substation.VOLTAGE_LEVEL_KV);
    substationJpaEntity.setLocation(getLocationPoint());
    substationJpaEntity.setCoverageArea(getCoverageArea());
    substationJpaEntity.setAffectedArea(getAffectedArea());
    substationJpaEntity.setCreatedAt(UnitTestsConstants.Substation.CREATED_AT);
    substationJpaEntity.setUpdatedAt(UnitTestsConstants.Substation.UPDATED_AT);
    substationJpaEntity.setDeletedAt(null);
    substationJpaEntity.setDeletedBy(null);
    return substationJpaEntity;
  }

  private static Polygon getAffectedArea() {
    Coordinate[] affectedAreaCoordinates = new Coordinate[]{
       new Coordinate(39.00, 15.00),
       new Coordinate(39.00, 16.00),
       new Coordinate(40.00, 16.00),
       new Coordinate(40.00, 15.00),
       new Coordinate(39.00, 15.00)
    };
    LinearRing affectedRing = FACTORY.createLinearRing(affectedAreaCoordinates);
    return FACTORY.createPolygon(affectedRing, null);
  }

  private static Polygon getCoverageArea() {
    Coordinate[] coverageAreaCoordinates = new Coordinate[]{
       new Coordinate(38.00, 13.00),
       new Coordinate(38.00, 14.00),
       new Coordinate(39.00, 14.00),
       new Coordinate(39.00, 13.00),
       new Coordinate(38.00, 13.00)
    };
    LinearRing coverageRing = FACTORY.createLinearRing(coverageAreaCoordinates);
    return FACTORY.createPolygon(coverageRing, null);
  }

  private static Point getLocationPoint() {
    return FACTORY.createPoint(new Coordinate(38.19, 13.56));
  }
}
