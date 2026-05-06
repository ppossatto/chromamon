package com.ppossatto.chromaback.transformers.internal.domain.exception;

import lombok.Getter;

@Getter
public class TransformerDomainException extends RuntimeException {

  public TransformerDomainException(TransformerDomainErrorMessage exceptionType, String... details) {
    super(String.format(exceptionType.getMessage(), details));
  }
}
