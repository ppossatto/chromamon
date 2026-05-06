package com.ppossatto.chromaback.transformers.internal.domain.model;

import com.ppossatto.chromaback.transformers.internal.domain.exception.TransformerDomainErrorMessage;
import com.ppossatto.chromaback.transformers.internal.domain.exception.TransformerDomainException;

import java.util.List;

public record PolygonCoordinates(
   List<Coordinates> points
) {
  public PolygonCoordinates {
    if (points == null || points.size() < 3) {
      throw new TransformerDomainException(
         TransformerDomainErrorMessage.POLYGON_POINTS_INSUFICIENT,
         points == null ? "none" : String.valueOf(points.size()));
    }
    points = List.copyOf(points);
  }
}
