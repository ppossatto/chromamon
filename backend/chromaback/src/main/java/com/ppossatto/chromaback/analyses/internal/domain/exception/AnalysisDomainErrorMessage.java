package com.ppossatto.chromaback.analyses.internal.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AnalysisDomainErrorMessage {
  ANALYSIS_STATUS_NOT_FOUND("Analysis status with name '%s' was not found!"),
  INPUT_SOURCE_TYPE_NOT_FOUND("Input source type with name '%s' was not found!");

  private final String message;
}
