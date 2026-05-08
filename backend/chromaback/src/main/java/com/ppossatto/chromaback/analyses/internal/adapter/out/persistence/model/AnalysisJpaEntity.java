package com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model;

import com.ppossatto.chromaback.analyses.internal.domain.enums.AnalysisStatus;
import com.ppossatto.chromaback.analyses.internal.domain.model.TableMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "analysis", schema = "analyses")
@Setter
@Getter
@NoArgsConstructor
public class AnalysisJpaEntity extends TableMetadata {

  @Column(name = "transformer_serial_number", length = 100, nullable = false)
  private String transformerSerialNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "input_source_id")
  private InputSourceTypeJpaEntity inputSourceType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "batch_id")
  private AnalysisBatchJpaEntity analysisBatch;

  @Column(name = "collected_by", length = 100, nullable = false)
  private String collectedBy;

  @Column(name = "collected_at", nullable = false)
  private LocalDateTime collectedAt;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private AnalysisStatus status = AnalysisStatus.PB;

  @Column(name = "status_updated_at")
  private LocalDateTime statusUpdatedAt;

  @Column(name = "h2_ppm", nullable = false, precision = 10, scale = 3)
  private BigDecimal h2Ppm;

  @Column(name = "ch4_ppm", nullable = false, precision = 10, scale = 3)
  private BigDecimal ch4Ppm;

  @Column(name = "c2h6_ppm", nullable = false, precision = 10, scale = 3)
  private BigDecimal c2h6Ppm;

  @Column(name = "c2h4_ppm", nullable = false, precision = 10, scale = 3)
  private BigDecimal c2h4Ppm;

  @Column(name = "c2h2_ppm", nullable = false, precision = 10, scale = 3)
  private BigDecimal c2h2Ppm;

  @Column(name = "o2_ppm", nullable = false, precision = 10, scale = 3)
  private BigDecimal o2Ppm;

  @Column(name = "co_ppm", nullable = false, precision = 10, scale = 3)
  private BigDecimal coPpm;

  @Column(name = "co2_ppm", nullable = false, precision = 10, scale = 3)
  private BigDecimal co2Ppm;

  @Column(name = "n2_ppm", nullable = false, precision = 10, scale = 3)
  private BigDecimal n2Ppm;

  @Column(name = "observations")
  @JdbcTypeCode(SqlTypes.JSON)
  private Map<String, Object> observations;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    AnalysisJpaEntity that = (AnalysisJpaEntity) o;
    return Objects.equals(transformerSerialNumber, that.transformerSerialNumber) && Objects.equals(inputSourceType, that.inputSourceType) && Objects.equals(analysisBatch, that.analysisBatch) && Objects.equals(collectedBy, that.collectedBy) && Objects.equals(collectedAt, that.collectedAt) && status == that.status && Objects.equals(statusUpdatedAt, that.statusUpdatedAt) && Objects.equals(h2Ppm, that.h2Ppm) && Objects.equals(ch4Ppm, that.ch4Ppm) && Objects.equals(c2h6Ppm, that.c2h6Ppm) && Objects.equals(c2h4Ppm, that.c2h4Ppm) && Objects.equals(c2h2Ppm, that.c2h2Ppm) && Objects.equals(o2Ppm, that.o2Ppm) && Objects.equals(coPpm, that.coPpm) && Objects.equals(co2Ppm, that.co2Ppm) && Objects.equals(n2Ppm, that.n2Ppm) && Objects.equals(observations, that.observations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transformerSerialNumber, inputSourceType, analysisBatch, collectedBy, collectedAt, status, statusUpdatedAt, h2Ppm, ch4Ppm, c2h6Ppm, c2h4Ppm, c2h2Ppm, o2Ppm, coPpm, co2Ppm, n2Ppm, observations);
  }
}
