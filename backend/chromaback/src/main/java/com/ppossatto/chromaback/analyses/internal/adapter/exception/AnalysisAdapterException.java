package com.ppossatto.chromaback.analyses.internal.adapter.exception;

public class AnalysisAdapterException extends RuntimeException {

  public AnalysisAdapterException(AnalysisAdapterErrorMessage exceptionType, String... details) {
    super(String.format(exceptionType.getMessage(), details));
  }
}
