package com.ppossatto.chromaback.analyses.internal.adapter.out.persistence;

import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model.InputSourceTypeJpaEntity;
import com.ppossatto.chromaback.analyses.internal.domain.enums.InputSourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InputSourceTypeJpaRepository extends JpaRepository<InputSourceTypeJpaEntity, Long> {

  Optional<InputSourceTypeJpaEntity> findByName (InputSourceType displayName);
}
