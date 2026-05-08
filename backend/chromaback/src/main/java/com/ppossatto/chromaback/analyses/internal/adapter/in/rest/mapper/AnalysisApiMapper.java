package com.ppossatto.chromaback.analyses.internal.adapter.in.rest.mapper;

import com.ppossatto.chromaback.analyses.internal.adapter.in.rest.dto.response.GetAnalysisByExternalIdResponse;
import com.ppossatto.chromaback.analyses.internal.application.dto.AnalysisDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnalysisApiMapper {

  @Mapping(target = "analysisStatus", source = "status.displayName")
  @Mapping(target = "inputSourceType", source = "inputSourceType.displayName")
  GetAnalysisByExternalIdResponse toResponse(AnalysisDto analysisDto);
}
