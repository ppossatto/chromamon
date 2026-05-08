package com.ppossatto.chromaback.transformers.internal.adapter.exception;

import lombok.Getter;

@Getter
public class TransformerAdapterException extends RuntimeException {

  public TransformerAdapterException(TransformerAdapterErrorMessage exceptionType, String... details) {
    super(String.format(exceptionType.getMessage(), details));
  }
}
