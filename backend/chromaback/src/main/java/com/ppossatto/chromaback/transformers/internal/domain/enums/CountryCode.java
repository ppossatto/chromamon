package com.ppossatto.chromaback.transformers.internal.domain.enums;

import com.ppossatto.chromaback.transformers.internal.domain.exception.TransformerDomainErrorMessage;
import com.ppossatto.chromaback.transformers.internal.domain.exception.TransformerDomainException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum CountryCode {
  AF("Afghanistan"),
  AL("Albania"),
  AR("Argentina"),
  AU("Australia"),
  BE("Belgium"),
  BG("Bulgaria"),
  BR("Brazil"),
  CA("Canada"),
  CH("Switzerland"),
  CL("Chile"),
  CN("China"),
  CO("Colombia"),
  CZ("Czech Republic"),
  DE("Germany"),
  DK("Denmark"),
  EE("Estonia"),
  EG("Egypt"),
  ES("Spain"),
  ET("Ethiopia"),
  FI("Finland"),
  FR("France"),
  GB("United Kingdom"),
  GR("Greece"),
  HR("Croatia"),
  HU("Hungary"),
  ID("Indonesia"),
  IE("Ireland"),
  IN("India"),
  IS("Iceland"),
  IT("Italy"),
  JP("Japan"),
  KR("South Korea"),
  LT("Lithuania"),
  LU("Luxembourg"),
  LV("Latvia"),
  ME("Montenegro"),
  MX("Mexico"),
  NL("Netherlands"),
  NO("Norway"),
  NZ("New Zealand"),
  PE("Peru"),
  PL("Poland"),
  PT("Portugal"),
  PY("Paraguay"),
  QA("Qatar"),
  RO("Romania"),
  RU("Russia"),
  SA("Saudi Arabia"),
  SE("Sweden"),
  SG("Singapore"),
  SI("Slovenia"),
  SK("Slovakia"),
  TH("Thailand"),
  US("United States"),
  ZA("South Africa"),
  AE("United Arab Emirates");

  private final String displayName;

  public static CountryCode fromDisplayName(String displayName){
    return Arrays.stream(CountryCode.values())
       .filter(c -> c.getDisplayName().equalsIgnoreCase(displayName))
       .findFirst()
       .orElseThrow(() -> new TransformerDomainException(TransformerDomainErrorMessage.COUNTRY_NAME_NOT_FOUND, displayName));
  }
}
