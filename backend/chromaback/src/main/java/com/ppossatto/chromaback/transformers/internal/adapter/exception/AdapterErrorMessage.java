package com.ppossatto.chromaback.transformers.internal.adapter.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AdapterErrorMessage {
  MANUFACTURER_BY_EXTERNAL_ID_NOT_FOUND("Manufacturer with id '%s' was not found!"),
  SUBSTATION_BY_EXTERNAL_ID_NOT_FOUND("Substation with id '%s' was not found!"),
  TRANSFORMER_SERIAL_NUMBER_NOT_FOUND("Transformer with serial number '%s' was not found!"),
  TRANSFORMER_BY_EXTERNAL_ID_NOT_FOUND("Transformer with id '%s' was not found!");

  private final String message;
}
