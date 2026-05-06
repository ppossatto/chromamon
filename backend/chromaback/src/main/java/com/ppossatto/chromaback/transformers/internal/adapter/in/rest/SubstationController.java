package com.ppossatto.chromaback.transformers.internal.adapter.in.rest;

import com.ppossatto.chromaback.config.WebConfig;
import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.SubstationByExternalIdResponse;
import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.mapper.SubstationApiMapper;
import com.ppossatto.chromaback.transformers.internal.application.service.SubstationService;
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
@RequestMapping("api/substations")
@RequiredArgsConstructor
@Slf4j
public class SubstationController {

  private final SubstationService substationService;
  private final SubstationApiMapper substationApiMapper;

  @PreAuthorize("hasAnyRole('BACKOFFICE', 'ENGINEER')")
  @GetMapping(value = "/{externalIdentifier}", version = WebConfig.Constants.VERSION_ONE)
  public ResponseEntity<SubstationByExternalIdResponse> getSubstationByExternalIdentifier(
     @PathVariable UUID externalIdentifier
  ) {
    log.info("Retrieve substation request for external ID: '{}'", externalIdentifier);
    SubstationByExternalIdResponse response =
       substationApiMapper.toResponse(
          substationService.getSubstationByExternalIdentifier(externalIdentifier)
       );

    log.debug("Substation retrieved, adding related links for HATEOAS...");

    response.add(linkTo(methodOn(SubstationController.class)
       .getSubstationByExternalIdentifier(externalIdentifier))
       .withSelfRel());
    // TODO: add relation for get affected area
    // TODO: add relation for get coverage area
    // TODO: add relation for get transformers in substation

    return ResponseEntity.ok(response);
  }
}
