package com.ppossatto.chromaback.analyses.internal.application.service;

import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisBatchDto;

import java.util.UUID;

public interface AnalysisBatchService {

  AnalysisBatchDto getAnalysisBatchByExternalId(UUID externalIdentifier);
}
