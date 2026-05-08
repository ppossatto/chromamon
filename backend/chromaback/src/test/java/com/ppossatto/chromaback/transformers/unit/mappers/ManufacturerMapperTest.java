package com.ppossatto.chromaback.transformers.unit.mappers;

import com.ppossatto.chromaback.UnitTestsConstants;
import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.ManufacturerJpaEntity;
import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerDto;
import com.ppossatto.chromaback.transformers.internal.application.mapper.ManufacturerMapper;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ManufacturerMapperTest {

  private ManufacturerMapper manufacturerMapper = Mappers.getMapper(ManufacturerMapper.class);

  @Test
  @DisplayName("From ManufacturerJpaEntity to ManufacturerDto mapping")
  void fromManufacturerJpaEntityToManufacturerDto() {
    ManufacturerDto expectedDto = getManufacturerDto();

    ManufacturerJpaEntity entityToBeMapped = getManufacturerJpaEntity();

    ManufacturerDto mappedDto = manufacturerMapper.toDto(entityToBeMapped);

    assertNotNull(mappedDto);
    assertEquals(expectedDto, mappedDto);
  }

  @Test
  @DisplayName("From ManufacturerDto to ManufaturerJPaEntity mapping")
  void fromManufacturerDtoToManufacturerJpaEntity() {
    ManufacturerJpaEntity expectedEntity = getManufacturerJpaEntity();
    expectedEntity.setTransformers(null);

    ManufacturerDto dtoToBeMapped = getManufacturerDto();

    ManufacturerJpaEntity responseEntity = manufacturerMapper.toEntity(dtoToBeMapped);

    assertNotNull(responseEntity);
    assertEquals(expectedEntity, responseEntity);
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

  private static ManufacturerDto getManufacturerDto() {
    return ManufacturerDto.builder()
       .externalIdentifier(UnitTestsConstants.Manufacturer.MANUFACTURER_1_EXTERNAL_IDENTIFIER)
       .name(UnitTestsConstants.Manufacturer.MANUFACTURER_1_NAME)
       .country(UnitTestsConstants.Manufacturer.MANUFACTURER_1_COUNTRY)
       .website(UnitTestsConstants.Manufacturer.MANUFACTURER_1_WEBSITE)
       .contactEmail(UnitTestsConstants.Manufacturer.MANUFACTURER_1_CONTACT_EMAIL)
       .isActive(UnitTestsConstants.Manufacturer.MANUFACTURER_1_IS_ACTIVE)
       .createdAt(UnitTestsConstants.Manufacturer.MANUFACTURER_1_CREATED_AT)
       .updatedAt(UnitTestsConstants.Manufacturer.MANUFACTURER_1_UPDATED_AT)
       .build();
  }
}
