package com.ppossatto.chromaback.transformers.unit.mappers;

import com.ppossatto.chromaback.UnitTestsConstants;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.ManufacturerJpaEntity;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.SubstationJpaEntity;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.TransformerJpaEntity;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;
import com.ppossatto.chromaback.transformers.internal.application.mapper.TransformerMapper;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.mapstruct.factory.Mappers;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransformerMapperTest {

  private static final GeometryFactory FACTORY = new GeometryFactory();

  private TransformerMapper transformerMapper = Mappers.getMapper(TransformerMapper.class);

  @Test
  @DisplayName("From TransformerJpaEntity to TransformerDto mapping")
  void fromTransformerJpaEntityToTransformerDto() {
    TransformerJpaEntity entityToBeMapped = getTransformerJpaEntity();

    TransformerDto expectedResponse = getTransformerDto();

    TransformerDto response = transformerMapper.toDto(entityToBeMapped);

    assertNotNull(response);
    assertEquals(expectedResponse, response);
  }

  @Test
  @DisplayName("From TransformerDto to TransformerJpaEntity mapping")
  void fromTransformerDtoToTransformerJpaEntity() {
    TransformerDto dtoToBeMapped = getTransformerDto();

    TransformerJpaEntity expectedResponse = getTransformerJpaEntity();
    expectedResponse.setSubstation(null);
    expectedResponse.setImagesUrls(null);
    expectedResponse.setDocumentsUrls(null);
    expectedResponse.setUniqueProperties(null);
    expectedResponse.setManufacturer(null);

    TransformerJpaEntity response = transformerMapper.toEntity(dtoToBeMapped);
    assertNotNull(response);
    assertEquals(expectedResponse, response);
  }

  private static TransformerDto getTransformerDto() {
    return TransformerDto.builder()
       .externalIdentifier(UnitTestsConstants.Transformers.TRANSFORMER_1_EXTERNAL_IDENTIFIER)
       .serialNumber(UnitTestsConstants.Transformers.TRANSFORMER_1_SERIAL_NUMBER)
       .manufacturerName(UnitTestsConstants.Manufacturer.MANUFACTURER_1_NAME)
       .substationName(UnitTestsConstants.Substation.SUBSTATION_NAME)
       .powerInputKv(UnitTestsConstants.Transformers.TRANSFORMER_1_POWER_INPUT)
       .efficiencyPercent(UnitTestsConstants.Transformers.TRANSFORMER_1_EFFICIENCY_PERCENT)
       .powerFactor(UnitTestsConstants.Transformers.TRANSFORMER_1_POWER_FACTOR)
       .phase(UnitTestsConstants.Transformers.TRANSFORMER_1_PHASE)
       .primaryVoltageKv(UnitTestsConstants.Transformers.TRANSFORMER_1_PRIMARY_VOLTAGE)
       .secondaryVoltageKv(UnitTestsConstants.Transformers.TRANSFORMER_1_SECONDARY_VOLTAGE)
       .importance(UnitTestsConstants.Transformers.TRANSFORMER_1_IMPORTANCE_CODE)
       .uniqueProperties(Collections.emptyMap())
       .imagesUrls(Collections.emptyList())
       .documentsUrls(Collections.emptyList())
       .condition(UnitTestsConstants.Transformers.TRANSFORMER_1_CONDITION)
       .createdAt(UnitTestsConstants.Transformers.TRANSFORMER_1_CREATED_AT)
       .updatedAt(UnitTestsConstants.Transformers.TRANSFORMER_1_UPDATED_AT)
       .build();
  }

  private static @NonNull TransformerJpaEntity getTransformerJpaEntity() {
    TransformerJpaEntity entityToBeMapped = new TransformerJpaEntity();
    entityToBeMapped.setExternalIdentifier(UnitTestsConstants.Transformers.TRANSFORMER_1_EXTERNAL_IDENTIFIER);
    entityToBeMapped.setSerialNumber(UnitTestsConstants.Transformers.TRANSFORMER_1_SERIAL_NUMBER);
    entityToBeMapped.setManufacturer(getManufacturerJpaEntity());
    entityToBeMapped.setSubstation(getSubstationJpaEntity());
    entityToBeMapped.setPowerInputKv(UnitTestsConstants.Transformers.TRANSFORMER_1_POWER_INPUT);
    entityToBeMapped.setEfficiencyPercent(UnitTestsConstants.Transformers.TRANSFORMER_1_EFFICIENCY_PERCENT);
    entityToBeMapped.setPowerFactor(UnitTestsConstants.Transformers.TRANSFORMER_1_POWER_FACTOR);
    entityToBeMapped.setPhase(UnitTestsConstants.Transformers.TRANSFORMER_1_PHASE);
    entityToBeMapped.setPrimaryVoltageKv(UnitTestsConstants.Transformers.TRANSFORMER_1_PRIMARY_VOLTAGE);
    entityToBeMapped.setSecondaryVoltageKv(UnitTestsConstants.Transformers.TRANSFORMER_1_SECONDARY_VOLTAGE);
    entityToBeMapped.setImportance(UnitTestsConstants.Transformers.TRANSFORMER_1_IMPORTANCE_CODE);
    entityToBeMapped.setUniqueProperties(UnitTestsConstants.Transformers.TRANSFORMER_1_UNIQUE_PROPERTIES);
    entityToBeMapped.setImagesUrls(UnitTestsConstants.Transformers.TRANSFORMER_1_IMAGES_URLS);
    entityToBeMapped.setDocumentsUrls(UnitTestsConstants.Transformers.TRANSFORMER_1_DOCUMENTS_URLS);
    entityToBeMapped.setCondition(UnitTestsConstants.Transformers.TRANSFORMER_1_CONDITION);
    entityToBeMapped.setCreatedAt(UnitTestsConstants.Transformers.TRANSFORMER_1_CREATED_AT);
    entityToBeMapped.setUpdatedAt(UnitTestsConstants.Transformers.TRANSFORMER_1_UPDATED_AT);
    entityToBeMapped.setDeletedAt(null);
    entityToBeMapped.setDeletedBy(null);
    return entityToBeMapped;
  }

  private static @NonNull ManufacturerJpaEntity getManufacturerJpaEntity() {
    ManufacturerJpaEntity entityToBeMapped = new ManufacturerJpaEntity();
    entityToBeMapped.setExternalIdentifier(UnitTestsConstants.Manufacturer.MANUFACTURER_1_EXTERNAL_IDENTIFIER);
    entityToBeMapped.setName(UnitTestsConstants.Manufacturer.MANUFACTURER_1_NAME);
    entityToBeMapped.setCountry(UnitTestsConstants.Manufacturer.MANUFACTURER_1_COUNTRY_CODE);
    entityToBeMapped.setWebsite(UnitTestsConstants.Manufacturer.MANUFACTURER_1_WEBSITE);
    entityToBeMapped.setActive(UnitTestsConstants.Manufacturer.MANUFACTURER_1_IS_ACTIVE);
    entityToBeMapped.setContactEmail(UnitTestsConstants.Manufacturer.MANUFACTURER_1_CONTACT_EMAIL);
    entityToBeMapped.setTransformers(Collections.emptySet());
    entityToBeMapped.setCreatedAt(UnitTestsConstants.Manufacturer.MANUFACTURER_1_CREATED_AT);
    entityToBeMapped.setUpdatedAt(UnitTestsConstants.Manufacturer.MANUFACTURER_1_UPDATED_AT);
    return entityToBeMapped;
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
