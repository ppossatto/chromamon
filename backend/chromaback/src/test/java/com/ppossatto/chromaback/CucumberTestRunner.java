package com.ppossatto.chromaback;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.test.context.ActiveProfiles;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/*")
@ActiveProfiles({"gherkin", "test"})
public class CucumberTestRunner {}
