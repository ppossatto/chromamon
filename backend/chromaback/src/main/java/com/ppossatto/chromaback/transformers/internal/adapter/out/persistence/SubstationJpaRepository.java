package com.ppossatto.chromaback.transformers.internal.adapter.out.persistence;

import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.SubstationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubstationJpaRepository extends JpaRepository<SubstationJpaEntity, Long> {

  Optional<SubstationJpaEntity> findByExternalIdentifier(UUID externalIdentifier);
}
