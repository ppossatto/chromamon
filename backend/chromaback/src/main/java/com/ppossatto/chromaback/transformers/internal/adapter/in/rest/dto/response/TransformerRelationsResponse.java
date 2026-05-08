package com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record TransformerRelationsResponse(
   UUID externalIdentifier,
   String serialNumber,
   String manufacturerName
) {
}
