package com.ppossatto.chromaback.analyses.internal.application.port.out;

import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisDto;

import java.util.UUID;

public interface AnalysisRepository {

  AnalysisDto getAnalysisByExternalId(UUID externalId);
}
