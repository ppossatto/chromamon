package com.ppossatto.chromaback.transformers.internal.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransformerDomainErrorMessage {
  CONDITION_NAME_NOT_FOUND("Condition with name '%s' was not found!"),
  COUNTRY_NAME_NOT_FOUND("Country with name '%s' was not found!"),
  IMPORTANCE_NAME_NOT_FOUND("Importance with name '%s' was not found!"),
  COORDINATES_OUT_OF_BOUNDS("The coordinates must be between '%s' and '%s' for the %s!"),
  POLYGON_POINTS_INSUFICIENT("The polygon must have at least 3 points! It currently have %s");

  private final String message;
}
