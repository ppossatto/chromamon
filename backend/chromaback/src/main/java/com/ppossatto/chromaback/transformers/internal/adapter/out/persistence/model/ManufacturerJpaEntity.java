package com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model;

import com.ppossatto.chromaback.transformers.internal.domain.enums.CountryCode;
import com.ppossatto.chromaback.transformers.internal.domain.model.TableMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "manufacturer", schema = "transformers")
@Getter
@NoArgsConstructor
@Builder
public class ManufacturerJpaEntity extends TableMetadata {

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "country", nullable = false)
  @Enumerated(EnumType.STRING)
  private CountryCode country;

  @Column(name = "website")
  private String website;

  @Column(name = "is_active", nullable = false)
  private boolean isActive = true;

  @Column(name = "contact_email")
  private String contactEmail;

  @OneToMany(mappedBy = "manufacturer")
  private Set<TransformerJpaEntity> transformers;
}
