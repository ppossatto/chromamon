package com.ppossatto.chromaback.analyses.internal.adapter.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AnalysisAdapterErrorMessage {

  ANALYSIS_BY_EXTERNAL_ID_NOT_FOUND("The analysis with external id '%s' was not found!"),
  INPUT_SOURCE_TYPE_NOT_FOUND("The input source type '%s' was not found!"),
  ANALYSIS_BATCH_EXTERNAL_IDENTIFIER_NOT_FOUND("The analysis batch with external id '%s' was not found!");

  private final String message;
}
