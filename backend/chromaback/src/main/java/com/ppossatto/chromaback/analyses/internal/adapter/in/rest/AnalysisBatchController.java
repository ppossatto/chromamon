package com.ppossatto.chromaback.analyses.internal.adapter.in.rest;

import com.ppossatto.chromaback.analyses.internal.adapter.in.rest.dto.response.GetAnalysisBatchByExternalIdResponse;
import com.ppossatto.chromaback.analyses.internal.adapter.in.rest.mapper.AnalysisBatchApiMapper;
import com.ppossatto.chromaback.analyses.internal.application.service.AnalysisBatchService;
import com.ppossatto.chromaback.config.WebConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("api/analysis-batches")
@RequiredArgsConstructor
@Slf4j
public class AnalysisBatchController {

  private final AnalysisBatchService analysisBatchService;
  private final AnalysisBatchApiMapper analysisBatchApiMapper;

  @GetMapping(value = "/{externalIdentifier}", version = WebConfig.Constants.VERSION_ONE)
  public ResponseEntity<GetAnalysisBatchByExternalIdResponse> getAnalysisBatchByExternalId(
     @PathVariable UUID externalIdentifier
  ) {
    log.info("Request for analysis batch with ID: '{}'", externalIdentifier);
    GetAnalysisBatchByExternalIdResponse response = analysisBatchApiMapper.toResponse(
       analysisBatchService.getAnalysisBatchByExternalId(externalIdentifier)
    );

    response.add(linkTo(methodOn(AnalysisBatchController.class)
       .getAnalysisBatchByExternalId(externalIdentifier))
       .withSelfRel());

    return ResponseEntity.ok(response);
  }
}
