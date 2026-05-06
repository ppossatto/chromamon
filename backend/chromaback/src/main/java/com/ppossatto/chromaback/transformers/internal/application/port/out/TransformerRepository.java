package com.ppossatto.chromaback.transformers.internal.application.port.out;

import com.ppossatto.chromaback.transformers.TransformerConditionEvent;
import com.ppossatto.chromaback.transformers.internal.application.dto.TransformerDto;

import java.util.List;
import java.util.UUID;

public interface TransformerRepository {

  TransformerDto getTransformerByExternalId(UUID externalId);

  List<String> getExistingTransformersBySerialNumber(List<String> serialNumbers);

  void updateTransformerCondition(TransformerConditionEvent event);
}
