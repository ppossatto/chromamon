package com.ppossatto.chromaback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void configureApiVersioning(ApiVersionConfigurer configurer) {
    configurer.addSupportedVersions(
       Constants.VERSION_ONE
       )
       .useRequestHeader(Constants.VERSION_HEADER)
       .setVersionParser(new ApiVersionParser());
  }

  public static class Constants {
    public static final String VERSION_ONE = "1.0";
    public static final String VERSION_HEADER = "X-API-Version";
  }
}
