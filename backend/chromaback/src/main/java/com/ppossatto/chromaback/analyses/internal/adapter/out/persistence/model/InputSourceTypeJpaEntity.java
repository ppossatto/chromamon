package com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model;

import com.ppossatto.chromaback.analyses.internal.domain.enums.InputSourceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "input_source_type", schema = "analyses")
@NoArgsConstructor
@Setter
@Getter
public class InputSourceTypeJpaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(name = "name", unique = true, nullable = false)
  @Enumerated(EnumType.STRING)
  private InputSourceType name;

  @Column(
     name = "created_at",
     nullable = false,
     updatable = false
  )
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @Setter
  @OneToMany(mappedBy = "inputSourceType")
  private Set<AnalysisJpaEntity> analysis;

  @PrePersist
  protected void onCreate() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

  @Override
  public String toString() {
    return "InputSourceTypeJpaEntity{" +
       "id=" + id +
       ", name=" + name +
       ", createdAt=" + createdAt +
       ", updatedAt=" + updatedAt +
       ", analysis=" + analysis +
       '}';
  }
}
