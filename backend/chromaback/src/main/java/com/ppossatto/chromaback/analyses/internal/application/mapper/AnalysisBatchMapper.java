package com.ppossatto.chromaback.analyses.internal.application.mapper;

import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model.AnalysisBatchJpaEntity;
import com.ppossatto.chromaback.analyses.internal.adapter.out.persistence.model.AnalysisJpaEntity;
import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisBatchDto;
import com.ppossatto.chromaback.analyses.internal.domain.model.TableMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnalysisBatchMapper {

  @Mapping(
     target = "analysisExternalIdentifiers",
     qualifiedByName = "getAnalysesExternalIdentifiers",
     source = "analyses"
  )
  AnalysisBatchDto toDto(AnalysisBatchJpaEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "analyses", ignore = true)
  AnalysisBatchJpaEntity toEntity(AnalysisBatchDto dto);

  @Named("getAnalysesExternalIdentifiers")
  default Set<UUID> getAnalysesExternalIdentifiers(Set<AnalysisJpaEntity> analyses) {
    if (analyses == null) {
      return Collections.emptySet();
    }
    return analyses.stream()
       .map(TableMetadata::getExternalIdentifier)
       .collect(Collectors.toSet());
  }
}

