package com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model;

import com.ppossatto.chromaback.analyses.internal.domain.enums.BatchStatusType;
import com.ppossatto.chromaback.analyses.internal.domain.model.TableMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "analysis_batch", schema = "analyses")
@Setter
@Getter
@NoArgsConstructor
public class AnalysisBatchJpaEntity extends TableMetadata {

  @Column(name = "submitted_by", length = 100, nullable = false)
  private String submittedBy;

  @Column(name = "submitted_at", nullable = false)
  private LocalDateTime submittedAt;

  @Column(name = "total_rows", nullable = false)
  private Integer totalRows;

  @Column(name = "processed_rows", nullable = false)
  private int processedRows;

  @Column(name = "skipped_rows")
  private int skippedRows;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private BatchStatusType status;

  @Column(name = "status_updated_at")
  private LocalDateTime statusUpdatedAt;

  @Column(name = "error_message")
  private String errorMessage;

  @Column(name = "enriched_csv_url", length = 500)
  private String enrichedCsvUrl;

  @OneToMany(mappedBy = "analysisBatch")
  private Set<AnalysisJpaEntity> analyses;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    AnalysisBatchJpaEntity that = (AnalysisBatchJpaEntity) o;
    return processedRows == that.processedRows && skippedRows == that.skippedRows && Objects.equals(submittedBy, that.submittedBy) && Objects.equals(submittedAt, that.submittedAt) && Objects.equals(totalRows, that.totalRows) && status == that.status && Objects.equals(statusUpdatedAt, that.statusUpdatedAt) && Objects.equals(errorMessage, that.errorMessage) && Objects.equals(enrichedCsvUrl, that.enrichedCsvUrl) && Objects.equals(analyses, that.analyses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(submittedBy, submittedAt, totalRows, processedRows, skippedRows, status, statusUpdatedAt, errorMessage, enrichedCsvUrl, analyses);
  }
}
