package com.ppossatto.chromaback.transformers.internal.adapter.exception;

import lombok.Getter;

@Getter
public class AdapterException extends RuntimeException {

  public AdapterException(AdapterErrorMessage exceptionType, String... details) {
    super(String.format(exceptionType.getMessage(), details));
  }
}
