package com.ppossatto.chromaback.transformers.internal.application.service;

import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerDto;

import java.util.UUID;

public interface ManufacturerService {

  ManufacturerDto getManufacturerByExternalIdentifier(UUID externalIdentifier);
}
