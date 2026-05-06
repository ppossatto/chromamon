package com.ppossatto.chromaback.transformers.internal.application.service;

import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationDto;

import java.util.UUID;

public interface SubstationService {

  SubstationDto getSubstationByExternalIdentifier(UUID externalIdentifier);
}
