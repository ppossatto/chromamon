package com.ppossatto.chromaback.transformers.internal.adapter.in.event;

import com.ppossatto.chromaback.transformers.TransformerConditionEvent;
import com.ppossatto.chromaback.transformers.internal.application.service.TransformerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TransformerConditionEventListener {

  private final TransformerService transformerService;

  @ApplicationModuleListener
  void onTransformerConditionEvent(TransformerConditionEvent event) {
    log.info("Transformer condition event received for transformer with serial number: {}", event.serialNumber());
    transformerService.setTransformerCondition(event);
  }
}
