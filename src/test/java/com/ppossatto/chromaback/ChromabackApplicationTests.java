package com.ppossatto.chromaback;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ChromabackApplicationTests {

	@Test
	void contextLoads() {
	}

}
