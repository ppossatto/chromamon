package com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model;

import com.ppossatto.chromaback.transformers.internal.domain.enums.ConditionCode;
import com.ppossatto.chromaback.transformers.internal.domain.enums.ImportanceCode;
import com.ppossatto.chromaback.transformers.internal.domain.model.TableMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "transformer", schema = "transformers")
@Getter
@NoArgsConstructor
@Builder
public class TransformerJpaEntity extends TableMetadata {

  @Column(name = "serial_number", length = 100, nullable = false, unique = true)
  private String serialNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "manufacturer_id")
  private ManufacturerJpaEntity manufacturer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "substation_id")
  private SubstationJpaEntity substation;

  @Column(name = "power_input_kva", nullable = false)
  private BigDecimal powerInputKv;

  @Column(name = "efficiency_percent", nullable = false)
  private BigDecimal efficiencyPercent;

  @Column(name = "power_factor", nullable = false)
  private BigDecimal powerFactor;

  @Column(name = "phase", nullable = false)
  private Integer phase;

  @Column(name = "primary_voltage_kv", nullable = false)
  private BigDecimal primaryVoltageKv;

  @Column(name = "secondary_voltage_kv", nullable = false)
  private BigDecimal secondaryVoltageKv;

  @Column(name = "importance", nullable = false)
  @Enumerated(EnumType.STRING)
  private ImportanceCode importance;

  @Column(name = "unique_properties")
  @JdbcTypeCode(SqlTypes.JSON)
  private Map<String, Object> uniqueProperties;

  @Column(name = "images_urls")
  @JdbcTypeCode(SqlTypes.ARRAY)
  private List<String> imagesUrls;

  @Column(name = "documents_urls")
  @JdbcTypeCode(SqlTypes.ARRAY)
  private List<String> documentsUrls;

  @Column(name = "condition", nullable = false)
  @Enumerated(EnumType.STRING)
  private ConditionCode condition;
}
