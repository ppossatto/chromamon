package com.ppossatto.chromaback.transformers.internal.application.dto;

import java.util.Set;

public record SubstationWithTransformerDto(
   SubstationDto substationDto,
   Set<TransformerDto> transformerDtos
) {
}
