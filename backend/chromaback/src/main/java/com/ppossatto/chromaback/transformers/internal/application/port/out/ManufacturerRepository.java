package com.ppossatto.chromaback.transformers.internal.application.port.out;

import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerDto;

import java.util.UUID;

public interface ManufacturerRepository {

  ManufacturerDto getManufacturerByExternalIdentifier(UUID externalId);
}
