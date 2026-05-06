package com.ppossatto.chromaback.transformers.internal.adapter.out.persistence;

import com.ppossatto.chromaback.transformers.internal.adapter.out.persistence.model.ManufacturerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ManufacturerJpaRepository extends JpaRepository<ManufacturerJpaEntity, Long> {

  Optional<ManufacturerJpaEntity> findByExternalIdentifier(UUID externalId);

}
