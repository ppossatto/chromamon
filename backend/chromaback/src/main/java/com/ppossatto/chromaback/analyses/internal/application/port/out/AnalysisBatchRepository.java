package com.ppossatto.chromaback.analyses.internal.application.port.out;

import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisBatchDto;

import java.util.UUID;

public interface AnalysisBatchRepository {

  AnalysisBatchDto findByExternalId(UUID externalIdentifier);
}
