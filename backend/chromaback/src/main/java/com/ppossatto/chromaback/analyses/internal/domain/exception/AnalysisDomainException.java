package com.ppossatto.chromaback.analyses.internal.domain.exception;

import lombok.Getter;

@Getter
public class AnalysisDomainException extends RuntimeException {

  public AnalysisDomainException(AnalysisDomainErrorMessage exceptionType, String... details) {
    super(String.format(exceptionType.getMessage(), details));
  }
}
