package com.ppossatto.chromaback.transformers.internal.domain.model;

import com.ppossatto.chromaback.transformers.internal.domain.exception.TransformerDomainErrorMessage;
import com.ppossatto.chromaback.transformers.internal.domain.exception.TransformerDomainException;

public record Coordinates(
   double latitude,
   double longitude
) {
  public Coordinates {
    if (latitude < -90 || latitude > 90) {
      throw new TransformerDomainException(TransformerDomainErrorMessage.COORDINATES_OUT_OF_BOUNDS, "-90", "90", "latitude");
    }
    if (longitude < -180 || longitude > 180) {
      throw new TransformerDomainException(TransformerDomainErrorMessage.COORDINATES_OUT_OF_BOUNDS, "-180", "180", "longitude");
    }
  }
}
