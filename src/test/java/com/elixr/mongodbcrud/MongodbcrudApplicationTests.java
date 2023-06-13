package com.elixr.mongodbcrud;

import io.micrometer.tracing.Tracer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
@SpringBootTest
@ContextConfiguration(classes = { Tracer.class})
class MongodbcrudApplicationTests {

	@Test
	void contextLoads() {
	}

}
