package com.ppossatto.chromaback;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@ActiveProfiles({"test", "smoke"})
class ApplicationTests {

  @Test
  @DisplayName("Verify service is running correctly")
  void contextLoads() {}
}
