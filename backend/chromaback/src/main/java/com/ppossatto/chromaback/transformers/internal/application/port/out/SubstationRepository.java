package com.ppossatto.chromaback.transformers.internal.application.port.out;

import com.ppossatto.chromaback.transformers.internal.application.dto.SubstationDto;

import java.util.UUID;

public interface SubstationRepository {

  SubstationDto getSubstationByExternalId(UUID externalId);
}
