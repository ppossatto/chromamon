package com.ppossatto.chromaback.transformers.internal.application.service;

import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationWithTransformerDto;

import java.util.UUID;

public interface SubstationService {

  SubstationWithTransformerDto getSubstationByExternalIdentifier(UUID externalIdentifier);
}
