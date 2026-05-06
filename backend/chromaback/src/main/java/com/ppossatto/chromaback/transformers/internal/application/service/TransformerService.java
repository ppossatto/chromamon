package com.ppossatto.chromaback.transformers.internal.application.service;

import com.ppossatto.chromaback.transformers.TransformerConditionEvent;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;

import java.util.UUID;

public interface TransformerService {

  TransformerDto getTransformerByExternalIdentifier(UUID externalIdentifier);

  void setTransformerCondition(TransformerConditionEvent event);
}
