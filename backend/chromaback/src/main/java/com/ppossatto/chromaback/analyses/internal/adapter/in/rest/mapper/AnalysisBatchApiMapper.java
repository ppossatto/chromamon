package com.ppossatto.chromaback.analyses.internal.adapter.in.rest.mapper;

import com.ppossatto.chromaback.analyses.internal.adapter.in.rest.dto.response.GetAnalysisBatchByExternalIdResponse;
import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisBatchDto;
import com.ppossatto.chromaback.analyses.internal.domain.enums.BatchStatusType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnalysisBatchApiMapper {

  @Mapping(target = "analyses", source = "analysisExternalIdentifiers")
  @Mapping(target = "status", qualifiedByName = "getStatusName")
  GetAnalysisBatchByExternalIdResponse toResponse(AnalysisBatchDto analysisBatchDto);

  @Named("getStatusName")
  default String getStatusName(BatchStatusType status) {
    if(status == null) return "";
    return status.name();
  }
}
