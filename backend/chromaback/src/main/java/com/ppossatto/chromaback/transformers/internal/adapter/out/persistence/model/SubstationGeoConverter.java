package com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model;

import com.ppossatto.chromaback.transformers.internal.domain.model.Coordinates;
import com.ppossatto.chromaback.transformers.internal.domain.model.PolygonCoordinates;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import java.util.Arrays;

public class SubstationGeoConverter {

  private static final GeometryFactory FACTORY = new GeometryFactory();

  public static Point fromCoordinatesToPoint(Coordinates coordinates) {
    Coordinate pointCoordinate = new Coordinate(coordinates.longitude(), coordinates.latitude());
    return FACTORY.createPoint(pointCoordinate);
  }

  public static Polygon fromPolygonCoordinatesToPolygon(PolygonCoordinates polygonCoordinates) {
    Coordinate[] areaCoordinates =
       polygonCoordinates.points()
          .stream()
          .map(p -> new Coordinate(p.longitude(), p.latitude()))
          .toList().toArray(new Coordinate[0]);

    Coordinate[] closedAreaCoordinates;
    if(!areaCoordinates[0].equals(areaCoordinates[areaCoordinates.length - 1])) {
      closedAreaCoordinates = Arrays.copyOf(areaCoordinates, areaCoordinates.length + 1);
      closedAreaCoordinates[closedAreaCoordinates.length - 1] = areaCoordinates[0];
    } else {
      closedAreaCoordinates = areaCoordinates;
    }

    LinearRing linearRing = FACTORY.createLinearRing(closedAreaCoordinates);

    return FACTORY.createPolygon(linearRing, null);
  }

  public static Coordinates fromPointToCoordinates(Point point) {
    return new Coordinates(point.getY(), point.getX());
  }

  public static PolygonCoordinates fromPolygonToPolygonCoordinates(Polygon polygon) {
    return new PolygonCoordinates(Arrays.stream(polygon.getCoordinates())
       .map(c -> new Coordinates(c.getY(), c.getX()))
       .toList());
  }
}
