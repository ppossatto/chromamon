package com.ppossatto.chromaback.transformers;

import com.ppossatto.chromaback.transformers.internal.domain.enums.ConditionCode;

public record TransformerConditionEvent(
   String serialNumber,
   String condition
) {
}
