package com.ppossatto.chromaback.transformers.internal.application.dto;

import java.util.Set;

public record ManufacturerWithTransformerDto(
   ManufacturerDto manufacturerDto,
   Set<TransformerDto> transformerDtos
) {
}
