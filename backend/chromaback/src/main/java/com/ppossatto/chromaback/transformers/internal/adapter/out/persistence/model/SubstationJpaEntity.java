package com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model;

import com.ppossatto.chromaback.transformers.internal.domain.model.TableMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import java.util.Set;

@Entity
@Table(name = "substation", schema = "transformers")
@Getter
@NoArgsConstructor
@Builder
public class SubstationJpaEntity extends TableMetadata {

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "operator", nullable = false, length = 150)
  private String operator;

  @Column(name = "voltage_level_kv", nullable = false)
  private Integer voltageLevelKv;

  @Column(name = "location", columnDefinition = "GEOMETRY(POINT, 4326)", nullable = false)
  private Point location;

  @Column(name = "coverage_area", columnDefinition = "GEOMETRY(POLYGON, 4326)", nullable = false)
  private Polygon coverageArea;

  @Column(name = "affected_area", columnDefinition = "GEOMETRY(POLYGON, 4326)", nullable = false)
  private Polygon affectedArea;

  @OneToMany(mappedBy = "substation")
  private Set<TransformerJpaEntity> transformers;
}
