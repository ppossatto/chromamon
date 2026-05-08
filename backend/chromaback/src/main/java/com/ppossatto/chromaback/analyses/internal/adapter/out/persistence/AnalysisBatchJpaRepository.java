package com.ppossatto.chromaback.analyses.internal.adapter.out.persistence;

import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model.AnalysisBatchJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnalysisBatchJpaRepository extends JpaRepository<AnalysisBatchJpaEntity, Long> {

  Optional<AnalysisBatchJpaEntity> findByExternalIdentifier(UUID externalIdentifier);
}
