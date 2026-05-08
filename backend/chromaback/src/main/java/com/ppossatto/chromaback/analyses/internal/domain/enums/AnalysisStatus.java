package com.ppossatto.chromaback.analyses.internal.domain.enums;

import com.ppossatto.chromaback.analyses.internal.domain.exception.AnalysisDomainErrorMessage;
import com.ppossatto.chromaback.analyses.internal.domain.exception.AnalysisDomainException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum AnalysisStatus {
  PB("Pending Batch"),
  AN("Analyzing"),
  PD("Pending Diagnostics"),
  DC("Diagnostics Completed"),
  FN("Finished"),
  RJ("Rejected");

  private final String displayName;

  public static AnalysisStatus fromDisplayName(String displayName) {
    return Arrays.stream(AnalysisStatus.values())
       .filter(a -> a.getDisplayName().equalsIgnoreCase(displayName))
       .findFirst()
       .orElseThrow(() -> new AnalysisDomainException(
          AnalysisDomainErrorMessage.ANALYSIS_STATUS_NOT_FOUND, displayName)
       );
  }
}
