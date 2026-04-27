package com.ppossatto.chromaback;

import org.springframework.boot.SpringApplication;

public class TestChromabackApplication {

  public static void main(String[] args) {
    SpringApplication.from(Application::main)
        .with(TestcontainersConfiguration.class)
        .run(args);
  }
}
