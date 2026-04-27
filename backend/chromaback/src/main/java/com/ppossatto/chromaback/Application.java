package com.ppossatto.chromaback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
@Slf4j
public class Application {

  private static final int DASH_COUNTER = 100;

  public static void main(String[] args) {
    Instant start = Instant.now();
    SpringApplication.run(Application.class, args);
    Instant end = Instant.now();

    log.info("-".repeat(DASH_COUNTER));
    log.info("Chromamon backend server started in {} ms", Duration.between(start, end).toMillis());
    log.info("-".repeat(DASH_COUNTER));
  }
}
