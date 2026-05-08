package com.ppossatto.chromaback.analyses.internal.adapter.out.persistence;

import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model.AnalysisJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnalysisJpaRepository extends JpaRepository<AnalysisJpaEntity, Long> {

  Optional<AnalysisJpaEntity> findByExternalIdentifier(UUID externalIdentifier);
}
