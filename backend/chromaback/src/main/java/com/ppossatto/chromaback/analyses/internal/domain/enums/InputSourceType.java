package com.ppossatto.chromaback.analyses.internal.domain.enums;

import com.ppossatto.chromaback.analyses.internal.domain.exception.AnalysisDomainErrorMessage;
import com.ppossatto.chromaback.analyses.internal.domain.exception.AnalysisDomainException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum InputSourceType {
  CSV("CSV"),
  MANUAL("Manual"),
  API("API");

  private final String displayName;

  public static InputSourceType fromDisplayName(String displayName) {
    return Arrays.stream(InputSourceType.values())
       .filter(i -> i.getDisplayName().equalsIgnoreCase(displayName))
       .findFirst()
       .orElseThrow(
          () -> new AnalysisDomainException(
             AnalysisDomainErrorMessage.INPUT_SOURCE_TYPE_NOT_FOUND, displayName
          )
       );
  }
}
