package com.ppossatto.chromaback.analyses.internal.application.service;

import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisDto;

import java.util.UUID;

public interface AnalysisService {

  AnalysisDto getAnalysisByExternalId(UUID externalIdentifier);
}
