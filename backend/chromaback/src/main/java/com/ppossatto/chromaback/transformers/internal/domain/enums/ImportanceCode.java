package com.ppossatto.chromaback.transformers.internal.domain.enums;

import com.ppossatto.chromaback.transformers.internal.domain.exception.TransformerDomainErrorMessage;
import com.ppossatto.chromaback.transformers.internal.domain.exception.TransformerDomainException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum ImportanceCode {

  CR("Critical"),
  HI("High"),
  MD("Medium"),
  LO("Low");

  private final String displayName;

  public static ImportanceCode fromDisplayName(String displayName) {
    return Arrays.stream(ImportanceCode.values())
       .filter(importanceCode -> importanceCode.displayName.equalsIgnoreCase(displayName))
       .findFirst()
       .orElseThrow(() -> new TransformerDomainException(TransformerDomainErrorMessage.IMPORTANCE_NAME_NOT_FOUND, displayName));
  }
}
