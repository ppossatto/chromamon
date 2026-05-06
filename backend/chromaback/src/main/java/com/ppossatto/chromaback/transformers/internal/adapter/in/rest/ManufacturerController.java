package com.ppossatto.chromaback.transformers.internal.adapter.in.rest;

import com.ppossatto.chromaback.config.WebConfig;
import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.dto.response.ManufacturerByExternalIdResponseDto;
import com.ppossatto.chromaback.transformers.internal.adapter.in.rest.mapper.ManufacturerApiMapper;
import com.ppossatto.chromaback.transformers.internal.application.service.ManufacturerService;
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
@RequestMapping("api/manufacturers")
@Slf4j
@RequiredArgsConstructor
public class ManufacturerController {

  private final ManufacturerService manufacturerService;
  private final ManufacturerApiMapper manufacturerApiMapper;

  @PreAuthorize("hasAnyRole('BACKOFFICE', 'ENGINEER')")
  @GetMapping(value = "/{externalIdentifier}", version = WebConfig.Constants.VERSION_ONE)
  public ResponseEntity<ManufacturerByExternalIdResponseDto> getManufacturerByExternalIdentifier(
     @PathVariable UUID externalIdentifier
  ) {
    log.info("Request for retrieving manufacturer by external identifier: '{}'", externalIdentifier);
    ManufacturerByExternalIdResponseDto response =
       manufacturerApiMapper.toGetManufacturerByExternalIdentifierResponse(
          manufacturerService.getManufacturerByExternalIdentifier(externalIdentifier)
       );

    log.debug("Manufacturer retrieved, adding related links for HATEOAS...");

    response.add(linkTo(methodOn(ManufacturerController.class)
       .getManufacturerByExternalIdentifier(externalIdentifier))
       .withSelfRel());
    //TODO: Add relation for get manufacturer transformers
    //TODO: Add relation for get all manufacturers

    return ResponseEntity.ok(response);
  }
}
