package com.ppossatto.chromaback.analyses.internal.adapter.in.rest;

import com.ppossatto.chromaback.analyses.internal.adapter.in.rest.dto.response.GetAnalysisByExternalIdResponse;
import com.ppossatto.chromaback.analyses.internal.adapter.in.rest.mapper.AnalysisApiMapper;
import com.ppossatto.chromaback.analyses.internal.application.service.AnalysisService;
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
@RequestMapping("api/analyses")
@RequiredArgsConstructor
@Slf4j
public class AnalysisController {

  private final AnalysisApiMapper analysisApiMapper;
  private final AnalysisService analysisService;

  @GetMapping(value = "/{externalIdentifier}", version = WebConfig.Constants.VERSION_ONE)
  public ResponseEntity<GetAnalysisByExternalIdResponse> getAnalysisByExternalId(
     @PathVariable UUID externalIdentifier
  ) {
    log.info("Requested analysis with external identifier: '{}'", externalIdentifier);
    GetAnalysisByExternalIdResponse response = analysisApiMapper.toResponse(
       analysisService.getAnalysisByExternalId(externalIdentifier)
    );

    response.add(linkTo(methodOn(AnalysisController.class)
       .getAnalysisByExternalId(externalIdentifier))
       .withSelfRel());

    return ResponseEntity.ok(response);
  }
}
