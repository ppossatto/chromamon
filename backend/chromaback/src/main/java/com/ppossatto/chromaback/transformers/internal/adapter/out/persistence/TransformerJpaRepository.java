package com.ppossatto.chromaback.transformers.internal.adapter.out.persistence;

import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.TransformerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransformerJpaRepository extends JpaRepository<TransformerJpaEntity, Long> {

  Optional<TransformerJpaEntity> findByExternalIdentifier(UUID externalIdentifier);

  @Query("SELECT t.serialNumber FROM TransformerJpaEntity t WHERE t.serialNumber IN :serialNumbers")
  List<String> findBySerialNumbers(@Param("serialNumbers") List<String> serialNumbers);

  Optional<TransformerJpaEntity> findBySerialNumber(String serialNumber);

  @Query("SELECT t FROM TransformerJpaEntity t WHERE t.id IN :ids")
  List<TransformerJpaEntity> findAllById(List<Long> ids);
}
