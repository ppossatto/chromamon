package com.ppossatto.chromaback.transformers.internal.domain.enums;

import com.ppossatto.chromaback.transformers.internal.domain.exception.TransformerDomainErrorMessage;
import com.ppossatto.chromaback.transformers.internal.domain.exception.TransformerDomainException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum ConditionCode {

  AC("Active"),
  WN("Warning"),
  DG("Danger"),
  MN("Maintenance");

  private final String displayName;

  public static ConditionCode fromDisplayName(String displayName) {
    return Arrays.stream(ConditionCode.values())
       .filter(conditionCode -> conditionCode.getDisplayName().equalsIgnoreCase(displayName))
       .findFirst()
       .orElseThrow(() -> new TransformerDomainException(TransformerDomainErrorMessage.CONDITION_NAME_NOT_FOUND, displayName));
  }
}
