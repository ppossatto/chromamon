package com.ppossatto.chromaback;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModulithTests {

  private static final ApplicationModules MODULES = ApplicationModules.of(Application.class);

  @Test
  @DisplayName("Verify no coupling")
  void verifyNoCoupling() {
    MODULES.verify();
  }

  @Test
  @DisplayName("Write UML")
  void writeUML() {
    new Documenter(MODULES).writeModulesAsPlantUml().writeIndividualModulesAsPlantUml();
  }
}
