package com.ppossatto.chromaback.transformers.internal.adapter.in.rest;

import com.ppossatto.chromaback.config.WebConfig;
import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.TransformerByExternalIdResponse;
import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.mapper.TransformerApiMapper;
import com.ppossatto.chromaback.transformers.internal.application.service.TransformerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/transformers")
@Slf4j
public class TransformerController {

  private final TransformerService transformerService;
  private final TransformerApiMapper transformerApiMapper;

  @PreAuthorize("hasAnyRole('BACKOFFICE', 'ENGINEER')")
  @GetMapping(value = "/{externalIdentifier}", version = WebConfig.Constants.VERSION_ONE)
  public ResponseEntity<TransformerByExternalIdResponse> getTransformerByExternalId(
     @PathVariable UUID externalIdentifier
  ) {
    log.info("Requested transformer with external identifier: '{}'", externalIdentifier);
    TransformerByExternalIdResponse response = transformerApiMapper
       .toResponse(
          transformerService.getTransformerByExternalIdentifier(externalIdentifier)
       );

    log.debug("Transformer retrieved, adding related links for HATEOAS...");

    response.add(linkTo(methodOn(TransformerController.class)
       .getTransformerByExternalId(externalIdentifier))
       .withSelfRel());
    // TODO: add relation for substation
    // TODO: add relation for manufacturer

    return ResponseEntity.ok(response);
  }
}
