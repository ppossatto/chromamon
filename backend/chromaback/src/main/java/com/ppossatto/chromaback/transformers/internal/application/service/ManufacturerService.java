package com.ppossatto.chromaback.transformers.internal.application.service;

import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerDto;
import com.ppossatto.chromaback.transformers.internal.application.dto.ManufacturerWithTransformerDto;

import java.util.UUID;

public interface ManufacturerService {

  ManufacturerWithTransformerDto getManufacturerByExternalIdentifier(UUID externalIdentifier);
}
